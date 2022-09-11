package com.naveenh.mynewsapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData
import com.naveenh.mydailynews.repository.NewsFeedRepo
import com.naveenh.mynewsapp.model.NewsFeedResponse

open class NewsFeedViewModel(application: Application) : AndroidViewModel(application) {

    val modelNewsFeedResp: MutableLiveData<NewsFeedResponse> by lazy {
        MutableLiveData<NewsFeedResponse>()
    }

    fun getNewsFeed() : LiveData<NewsFeedResponse> {
        NewsFeedRepo.getServiceApiCall(modelNewsFeedResp)
        return modelNewsFeedResp
    }

    private fun loadUsers() {
        Log.i("Naveen", "loadUsers on NewsFeedViewModel")
    }

}