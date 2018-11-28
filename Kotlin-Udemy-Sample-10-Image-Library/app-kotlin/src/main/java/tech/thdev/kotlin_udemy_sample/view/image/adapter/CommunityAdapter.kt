package tech.thdev.kotlin_udemy_sample.view.image.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.AllChannel
import tech.thdev.kotlin_udemy_sample.data.PhotoItem
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageAsyncViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageCommunityViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageGlideViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.holder.ImageThreadViewHolder
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract2
import java.util.*

/**
 * Created by Administrator on 2018-01-10.
 */
class CommunityAdapter(private val context: Context) :
        RecyclerView.Adapter<BaseViewHolder<AllChannel>>(),
        ImageViewAdapterContract2.View, ImageViewAdapterContract2.Model {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<AllChannel>? =
        ImageCommunityViewHolder(context, parent)

    companion object {
        val VIEW_TYPE_ASYNC = 100
        val VIEW_TYPE_THREAD = 200
        val VIEW_TYPE_GLIDE = 300

    }

    val itemList: MutableList<AllChannel> = ArrayList()

    /*override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = when (viewType) {
        VIEW_TYPE_ASYNC -> ImageAsyncViewHolder(context, parent)
        VIEW_TYPE_THREAD -> ImageThreadViewHolder(context, parent)
        else -> ImageCommunityViewHolder(context, parent)
    }*/

    override fun onBindViewHolder(holder: BaseViewHolder<AllChannel>?, position: Int) {
        holder?.bindView(getItem(position), position)
    }

    override fun getItemViewType(position: Int) = getItem(position).viewType

    /**
     * Item list의 item을 return
     */
    private fun getItem(position: Int) = itemList.get(position)

    /**
     * Item size를 return
     */
    override fun getItemCount() = itemList.size

    override fun addItem(item: AllChannel) {
        itemList.add(item)
    }

    override fun clear() {
        itemList.clear()
    }

    override fun reload() {
        notifyDataSetChanged()
    }
}