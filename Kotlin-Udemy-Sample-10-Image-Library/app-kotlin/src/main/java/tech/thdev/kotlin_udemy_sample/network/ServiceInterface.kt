package tech.thdev.kotlin_udemy_sample.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import tech.thdev.kotlin_udemy_sample.BuildConfig
import tech.thdev.kotlin_udemy_sample.data.CommunityResponse
import tech.thdev.kotlin_udemy_sample.data.PhotoResponse

/**
 * Created by Administrator on 2018-01-10.
 */
interface ServiceInterface {
    @GET("api/community/main")
    fun getCommunity() : Call<CommunityResponse>

}