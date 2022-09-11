package com.naveenh.mynewsapp.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naveenh.mydailynews.R
import com.naveenh.mydailynews.model.NewsFeedData

class NewsFeedAdapter(context: Context) : RecyclerView.Adapter<NewsFeedAdapter.ViewHolder>() {

    private var contxt: Context = context
    private var modelList : ArrayList<NewsFeedData>? = null

    @SuppressLint("NotifyDataSetChanged")
    fun updateNewsFeed(list: ArrayList<NewsFeedData>) {

        if(modelList != null) {
            modelList!!.clear()
        }
            modelList = list
            Log.i("Naveen", " updateNewsFeed modelList=> "+ modelList)
            notifyDataSetChanged()


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i("Naveen ", "onCreateViewHolder ");
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       Log.i("Naveen ", "onBindViewHolder : "+ modelList!![position].title)
        holder.txtViewTitle.text = modelList!![position].title
        holder.txtViewDescription.text = modelList!![position].Description
        holder.txtViewAuthor.text = modelList!![position].author
        Glide.with(contxt).load(modelList!![position].imgURL)
            .placeholder(R.drawable.no_images)
            .into(holder.img)
    }

    override fun getItemCount(): Int {
        if(modelList == null)
            return 0
        else
            return modelList!!.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         var txtViewTitle : TextView = itemView.findViewById(R.id.textViewTitle)
        var txtViewDescription : TextView = itemView.findViewById(R.id.textViewDescription)
        var txtViewAuthor: TextView = itemView.findViewById(R.id.textViewAuthor)
        var img: ImageView = itemView.findViewById(R.id.imageivew)

    }


}