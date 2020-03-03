package com.example.hqtv.customcomponents


import android.media.Image
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.example.hqtv.R
import com.example.hqtv.commonutils.Constants



/**
 * Created by manuramv on 2020-03-03.
 */

    @BindingAdapter("imageURL")
    fun ImageView.imageUrl(path: String?) {
        Glide.with(this.context).load(buildURL(path)).placeholder(R.mipmap.ic_launcher).fitCenter().into(this)
    }



    fun buildURL(url: String?): String {
        return Constants.BASE_IMAGE_URL + url
    }


