package com.example.hqtv.view

import android.provider.SyncStateContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.LiveData
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.hqtv.R
import com.example.hqtv.commonutils.Constants
import com.example.hqtv.commonutils.ItemCheckCallBack

import com.example.hqtv.models.MoviesResponse
import com.example.hqtv.models.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_item.view.*


/**
 * Created by manuramv on 2020-02-29.
 */
class MovieAdapter() : PagedListAdapter<Result, MovieAdapter.ViewHolder>( ItemCheckCallBack()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }



    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val requestOption = RequestOptions().placeholder(R.drawable.img_loader).error(R.drawable.img_loader).centerCrop()
        val img = itemView.imgMovieThumbNail
        fun bind(item: Result) {
            Glide.with(itemView.context).load(Constants.BASE_IMAGE_URL+item.poster_path).apply(requestOption).into(img)
        }
    }





}