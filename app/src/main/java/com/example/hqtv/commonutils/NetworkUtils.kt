package com.example.hqtv.commonutils

import android.content.Context
import android.net.ConnectivityManager

/**
 * Created by manuramv on 2020-03-03.
 */
object NetworkUtils {
    fun isNetworkAvailable(context: Context?): Boolean {
        val connectivityManager = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        val activeNetworkInfo = connectivityManager?.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
}