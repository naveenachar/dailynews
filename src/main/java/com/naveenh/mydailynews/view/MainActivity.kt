package com.naveenh.mydailynews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.naveenh.mydailynews.R
import com.naveenh.mydailynews.model.NewsFeedData
import com.naveenh.mynewsapp.model.NewsFeedResponse
import com.naveenh.mynewsapp.view.NewsFeedFragment
import com.naveenh.mynewsapp.viewmodel.NewsFeedViewModel

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("Naveen","oncreate activity")

        supportFragmentManager.commit {
            add<NewsFeedFragment>(R.id.fragment_main, args = savedInstanceState)
        }
    }

}