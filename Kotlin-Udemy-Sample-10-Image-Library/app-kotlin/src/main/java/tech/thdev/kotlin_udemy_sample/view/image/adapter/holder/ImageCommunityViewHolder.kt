package tech.thdev.kotlin_udemy_sample.view.image.adapter.holder

import android.content.Context
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_image_view.view.*
import tech.thdev.kotlin_udemy_sample.R
import tech.thdev.kotlin_udemy_sample.base.adapter.BaseViewHolder
import tech.thdev.kotlin_udemy_sample.data.AllChannel
import tech.thdev.kotlin_udemy_sample.data.PhotoItem
import tech.thdev.kotlin_udemy_sample.network.image.ImageDownloadAsync

/**
 * Created by Administrator on 2018-01-10.
 */
class ImageCommunityViewHolder(context: Context, parent: ViewGroup?) :
        BaseViewHolder<AllChannel>(R.layout.item_image_view, context, parent) {
    override fun bindView(item: AllChannel?, position: Int) {
        itemView?.let {
            // kotlin extensions 이용 view 사용
            with(it) {
                tv_title.text = item?.title
                Glide.with(context)
                        .load(item?.getImage())
                        .centerCrop()
                        .placeholder(R.drawable.loading)
                        .into(image)
            }
        }
    }
}