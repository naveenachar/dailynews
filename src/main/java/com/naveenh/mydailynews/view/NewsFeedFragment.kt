package com.naveenh.mynewsapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.naveenh.mydailynews.R
import com.naveenh.mydailynews.model.NewsFeedData
import com.naveenh.mynewsapp.model.NewsFeedResponse
import com.naveenh.mynewsapp.viewmodel.NewsFeedViewModel
import kotlinx.android.synthetic.main.newsfeed_fragment_layout.*
import kotlin.math.log


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class NewsFeedFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var newsFeedList: List<NewsFeedData>? = null
    private var newsFeedAdapter: NewsFeedAdapter? = null
    lateinit var recycler_view :RecyclerView

    private val newsViewModel: NewsFeedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        ViewModelProvider(this)[NewsFeedViewModel::class.java]
        //newsViewModel.getNewsFeed().observe(this, newsListObserver)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.newsfeed_fragment_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Naveen", "onViewCreated")
        recycler_view = view?.findViewById(R.id.newsfeed_recyclerview) as RecyclerView
        recycler_view.layoutManager = LinearLayoutManager(requireView().context)
        newsFeedAdapter = NewsFeedAdapter(requireContext())
        recycler_view.adapter = newsFeedAdapter

        newsViewModel.getNewsFeed().observe(viewLifecycleOwner, Observer {
            it?.let {
                Log.i("Naveen", "INside observer"+it.newsList)
                this.newsFeedAdapter!!.updateNewsFeed(it.newsList as ArrayList<NewsFeedData>) }
        })
    }

    private val newsListObserver = Observer<NewsFeedResponse> { newsList ->
       Log.i("Naveen", " MainActivity Airline list Observer")

        if(newsFeedAdapter == null ) {
            newsFeedList = newsList.newsList!!
            //newsFeedAdapter = NewsFeedAdapter(newsFeedList as ArrayList<NewsFeedData>, requireActivity().applicationContext)
            recycler_view.adapter = newsFeedAdapter
        }
        else {
            newsFeedAdapter?.updateNewsFeed( newsFeedList as ArrayList<NewsFeedData>)
        }

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NewsFeedFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}