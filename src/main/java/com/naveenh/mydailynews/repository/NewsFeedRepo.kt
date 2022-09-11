package com.naveenh.mydailynews.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.naveenh.mynewsapp.model.NewsFeedResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object NewsFeedRepo {

    var TAG: String = "Naveen"

    fun getServiceApiCall(airLineDataList : MutableLiveData<NewsFeedResponse>): MutableLiveData<NewsFeedResponse> {


        var apiInterface: RetrofitService = NetworkCall().getApiClient()!!.create(RetrofitService::class.java)

        var call = apiInterface.getNewsFeed()

        call.enqueue(object : Callback<NewsFeedResponse> {

            override fun onResponse(call: Call<NewsFeedResponse>?, response: Response<NewsFeedResponse>?) {
                Log.i("", "onResponse() Success: " + response?.body())
                airLineDataList.postValue(response?.body())
            }

            override fun onFailure(call: Call<NewsFeedResponse>?, t: Throwable?) {
                Log.i(TAG, "onResponse() onFailure")
                if (t != null) {
                    Log.i(TAG, "onResponse() onFailure"+t.message.toString())
                }
            }
        })

        Log.i(TAG,"=>"+apiInterface+" ->"+apiInterface.getNewsFeed().isExecuted);

        return airLineDataList;
    }

}