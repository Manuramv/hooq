package com.example.hqtv.repo

import com.example.hqtv.commonutils.Constants
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by manuramv on 2020-02-24.
 */
interface APIServiceInterface{

    @GET(Constants.MOVIES_NOW_PLAYING)
    fun getNowPlayingMovies(@Query ("page")page:Int, @Query("api_key")apikey: String)
}