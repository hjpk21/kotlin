package tech.thdev.kotlin_udemy_sample.view.image.adapter.model

import tech.thdev.kotlin_udemy_sample.data.AllChannel
import tech.thdev.kotlin_udemy_sample.data.PhotoItem

/**
 * Created by Administrator on 2018-01-10.
 */
interface ImageViewAdapterContract2 {

    interface View {
        fun reload()
    }

    /**
     * Adapter에서 사용할 Model에 대한 interface 정의
     */
    interface Model {
        fun addItem(item: AllChannel)
        /**
         * Item clear 추가
         */
        fun clear()
    }
}