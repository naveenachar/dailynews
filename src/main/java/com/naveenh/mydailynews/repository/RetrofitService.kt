package com.naveenh.mydailynews.repository


import com.naveenh.mynewsapp.model.NewsFeedResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("v2/top-headlines?country=us&apiKey=")
    //@GET("airlines")
    fun getNewsFeed() : Call<NewsFeedResponse>

}