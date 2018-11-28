package tech.thdev.kotlin_udemy_sample.view.image

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_image_sample.*
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.data.model.DataSource
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.image.adapter.CommunityAdapter
import tech.thdev.kotlin_udemy_sample.view.image.adapter.ImageAdapter
import tech.thdev.kotlin_udemy_sample.view.image.presenter.ImageCommunityContract
import tech.thdev.kotlin_udemy_sample.view.image.presenter.ImageCommunityPresenter
import tech.thdev.kotlin_udemy_sample.view.image.presenter.ImageContract
import tech.thdev.kotlin_udemy_sample.view.image.presenter.ImagePresenter

/**
 * Created by Administrator on 2018-01-10.
 */
class ImageCommunityFragment : Fragment(), ImageCommunityContract.View {

    private val fab by lazy {
        activity.findViewById(R.id.fab) as FloatingActionButton
    }

    // Java 식의 static instance
    companion object {
        fun getInstance() = ImageCommunityFragment()
    }

    private var imageAdapter: CommunityAdapter? = null

    private var presenter: ImageCommunityContract.Presenter? = null

    /**
     * ViewType 정의
     */
    private var mViewType = ImageAdapter.VIEW_TYPE_GLIDE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View?
            = inflater?.inflate(R.layout.fragment_image_sample, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = ImageCommunityPresenter()
        presenter?.view = this

        imageAdapter = CommunityAdapter(context)

        /**
         * Model을 생성하여 셋팅한다
         */
        presenter?.photoDataSample = DataSource

        presenter?.adapterModel = imageAdapter
        presenter?.adapterView = imageAdapter

        recycler_image.adapter = imageAdapter

        fab.setOnClickListener {
            presenter?.getCommunity(mViewType)
        }

        presenter?.getCommunity(mViewType)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_async -> {
                changeViewType(ImageAdapter.VIEW_TYPE_ASYNC, item)
                return true
            }
            R.id.action_thread -> {
                changeViewType(ImageAdapter.VIEW_TYPE_THREAD, item)
                return true
            }
            R.id.action_glide -> {
                changeViewType(ImageAdapter.VIEW_TYPE_GLIDE, item)
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }

    private fun changeViewType(viewType: Int, item: MenuItem?) {
        mViewType = ImageAdapter.VIEW_TYPE_GLIDE
        presenter?.getCommunity(mViewType)
        if (item?.isChecked ?: false) item?.isChecked = false
        else item?.isChecked = true
    }

    override fun showLoadFailMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        Log.e("TAG", "Exception : " + message)
    }

    override fun showLoadSuccess() {
        Toast.makeText(context, "Load success", Toast.LENGTH_SHORT).show()
    }

    override fun showLoadFail() {
        Toast.makeText(context, "Load fail", Toast.LENGTH_SHORT).show()
    }
}