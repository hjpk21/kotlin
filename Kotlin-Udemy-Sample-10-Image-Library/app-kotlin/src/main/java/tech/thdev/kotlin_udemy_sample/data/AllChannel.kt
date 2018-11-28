package tech.thdev.kotlin_udemy_sample.data

import android.util.Log
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by Administrator on 2018-01-10.
 */
data class AllChannel(@SerializedName("thumbImageUrl")
                      @Expose
                      var thumbImageUrl : String,
                      @SerializedName("channelId")
                      @Expose
                      val channelId : String,
                      @SerializedName("title")
                      @Expose
                      val title :String,
                      @SerializedName("isNew")
                      @Expose
                      val isNew : Boolean,
                      var viewType: Int = 0) {
    fun getImage(): String {

        if (thumbImageUrl != null) {
            if (thumbImageUrl.startsWith("http")) {
                //Log.d(" Banner thumbimage", thumbImageUrl)
                thumbImageUrl
            } else {
                thumbImageUrl = "http://dev-m.kaybo1.com$thumbImageUrl"
                //Log.d(" Banner thumbimage2", thumbImageUrl)
            }
        } else {

        }

        return thumbImageUrl
    }
}