package com.example.hqtv.view

import android.provider.SyncStateContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hqtv.R
import com.example.hqtv.commonutils.Constants
import com.example.hqtv.models.MoviesResponse
import com.squareup.picasso.Picasso

/**
 * Created by manuramv on 2020-02-29.
 */
class MovieAdapter(val movieData: MoviesResponse) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.movie_item,parent,false))
    }

    override fun getItemCount(): Int {
        return movieData.results.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      // holder.imgView.setImageResource(R.drawable.ic_launcher_background)
        //Picasso.with(holder.imgView.context).load(Constants.BASE_IMAGE_URL+movieData.results.get(position).poster_path).into(holder.imgView)
        Glide.with(holder.imgView.context).load(Constants.BASE_IMAGE_URL+movieData.results.get(position).poster_path).into(holder.imgView)

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgView: ImageView = itemView.findViewById(R.id.imgMovieThumbNail);

    }


}