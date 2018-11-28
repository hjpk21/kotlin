package tech.thdev.kotlin_udemy_sample.view.image.presenter

import tech.thdev.kotlin_udemy_sample.data.model.DataSource
import tech.thdev.kotlin_udemy_sample.data.model.PhotoDataSource
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract
import tech.thdev.kotlin_udemy_sample.view.image.adapter.model.ImageViewAdapterContract2

/**
 * Created by Administrator on 2018-01-10.
 */
interface ImageCommunityContract {

    interface View {

        /**
         * 로딩 완료
         */
        fun showLoadSuccess()

        /**
         * 로딩 실패
         */
        fun showLoadFail()

        fun showLoadFailMessage(message: String)
    }

    interface Presenter {

        var view: View?

        /**
         * Model
         */
        var photoDataSample: DataSource?

        /**
         * Adapter에 대한 View/Model을 정의한다
         */
        var adapterModel: ImageViewAdapterContract2.Model?
        var adapterView: ImageViewAdapterContract2.View?

        /**
         * Flickr image을 불러온다
         */
        fun getCommunity(viewType: Int)
    }
}