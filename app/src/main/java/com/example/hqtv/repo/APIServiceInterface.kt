package com.example.hqtv.repo

import com.example.hqtv.commonutils.Constants
import com.example.hqtv.models.MoviesResponse
import io.reactivex.Observable
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by manuramv on 2020-02-24.
 */
interface APIServiceInterface{

    @GET(Constants.MOVIES_NOW_PLAYING)
    fun getNowPlayingMovies(@Query ("page")page:Int, @Query("api_key")apikey: String) :Observable<MoviesResponse>

    @GET(Constants.MOVIES_NOW_PLAYING)
    suspend fun getNewMoviess(@Query ("page")page:Int, @Query("api_key")apikey: String) :MoviesResponse
}