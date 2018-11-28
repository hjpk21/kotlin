package tech.thdev.kotlin_udemy_sample.view.image.presenter

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import tech.thdev.kotlin_udemy_sample.data.CommunityResponse
import tech.thdev.kotlin_udemy_sample.data.PhotoResponse
import tech.thdev.kotlin_udemy_sample.data.model.DataSource
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.image.adapter.ImageAdapter
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract2

/**
 * Created by Administrator on 2018-01-10.
 */
class ImageCommunityPresenter : ImageCommunityContract.Presenter {
    override fun getCommunity(viewType: Int) {
        if (mViewType != viewType) {
            adapterModel?.clear()
        }
        mViewType = viewType
        photoDataSample?.getCommunity()
                ?.enqueue(object : Callback<CommunityResponse>{
                    override fun onFailure(call: Call<CommunityResponse>?, t: Throwable?) {
                        view?.showLoadFail()
                    }

                    override fun onResponse(call: Call<CommunityResponse>?, response: Response<CommunityResponse>?) {
                        if (response?.isSuccessful ?:false){
                            Log.d("TAG", "response raw " + response?.raw())
                            val communityResponse = response?.body()
                            if(response?.raw()?.code()!!.equals(200)){
                                communityResponse?.allChannel?.forEach {
                                    adapterModel?.addItem(it)
                                }
                                adapterView?.reload()

                                view?.showLoadSuccess()

                            }else{
                                view?.showLoadFailMessage("Code ${response?.raw()?.code()}, message ${response?.raw()?.message()}")
                            }

                        }else{
                            view?.showLoadFail()
                        }
                    }

                })
    }

    override var view: ImageCommunityContract.View? = null

    override var photoDataSample: DataSource? = null

    override var adapterModel: ImageViewAdapterContract2.Model? = null
    override var adapterView: ImageViewAdapterContract2.View? = null

    var page = 0
    var mViewType: Int = ImageAdapter.VIEW_TYPE_GLIDE

   /* override fun getRecentImageSample(viewType: Int) {
        if (mViewType != viewType) {
            adapterModel?.clear()
        }
        mViewType = viewType

        // object callback을 정의한다
        photoDataSample?.getRecentPhoto(++page)
                ?.enqueue(object : Callback<PhotoResponse> {

                    override fun onResponse(call: Call<PhotoResponse>?, response: Response<PhotoResponse>?) {
                        if (response?.isSuccessful ?: false) {
//                            Log.d("TAG", "response raw " + response?.raw())

                            val photoResponse = response?.body()
                            if (photoResponse?.stat.equals("ok")) {
                                photoResponse?.photos?.photo?.forEachIndexed { i, photoItem ->
                                    photoItem.viewType = mViewType
                                    adapterModel?.addItem(photoItem)
                                }

                                // adapter의 reload
                                adapterView?.reload()

                                view?.showLoadSuccess()

                            } else {
                                view?.showLoadFailMessage("Code ${photoResponse?.code}, message ${photoResponse?.message}")
                            }

                        } else {
                            view?.showLoadFail()
                        }
                    }

                    override fun onFailure(call: Call<PhotoResponse>?, t: Throwable?) {
                        view?.showLoadFail()
                    }
                })
    }*/
}