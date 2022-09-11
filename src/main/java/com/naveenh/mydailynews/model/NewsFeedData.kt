package com.naveenh.mydailynews.model

import com.google.gson.annotations.SerializedName
import java.net.URL

data class NewsFeedData(
    @SerializedName("title") val title:String,
    @SerializedName("author") val author:String,
    @SerializedName("description") val Description:String,
    @SerializedName("urlToImage") val imgURL:String,
    @SerializedName("url") val newsURL:String,
    @SerializedName("publishedAt") val publishDate: String)

