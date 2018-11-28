package tech.thdev.kotlin_udemy_sample.data.model

import tech.thdev.kotlin_udemy_sample.network.FlickrServiceInterface
import tech.thdev.kotlin_udemy_sample.network.ServiceInterface
import tech.thdev.kotlin_udemy_sample.network.createRetrofit

/**
 * Created by Administrator on 2018-01-10.
 */
object DataSource {

    //val FLICKR_URL = "https://api.flickr.com/services/rest/"
    val FLICKR_URL = "http://dev-m.kaybo1.com/"


    private val serviceInterface: ServiceInterface

    init {

        serviceInterface = createRetrofit(ServiceInterface::class.java, FLICKR_URL)
    }

    /**
     * Flickr 아이템을 불러온다
     */

    fun getCommunity() = serviceInterface.getCommunity()
}