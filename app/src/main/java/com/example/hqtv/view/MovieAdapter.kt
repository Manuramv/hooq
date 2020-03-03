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
import com.example.hqtv.databinding.MovieItemBinding
import com.example.hqtv.models.MoviesResponse
import com.squareup.picasso.Picasso



/**
 * Created by manuramv on 2020-02-29.
 */
class MovieAdapter(val movieData: ArrayList<RowItemViewModel>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movieData.get(position))
    }


    class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: RowItemViewModel) {
            binding.viewModel = item
            binding.executePendingBindings()
        }

    }


}