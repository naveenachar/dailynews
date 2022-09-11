package com.naveenh.mydailynews.repository

import android.util.Log
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkCall {

    var BASE_URL: String = "https://newsapi.org/"
   // var BASE_URL: String = "https://www.kayak.com/h/mobileapis/directory/"
    var retrofit: Retrofit? = null

    fun getApiClient(): Retrofit? {
        Log.i("Naveen","URL"+BASE_URL)
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }
        return retrofit
    }
}