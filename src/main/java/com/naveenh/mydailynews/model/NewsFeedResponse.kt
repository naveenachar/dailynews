package com.naveenh.mynewsapp.model

import com.google.gson.annotations.SerializedName
import com.naveenh.mydailynews.model.NewsFeedData
import java.net.URL

data class NewsFeedResponse(

    @SerializedName("status") val status:String,
    @SerializedName("totalResults") val totalResults: Int,
    @SerializedName("articles") val newsList:List<NewsFeedData>)
