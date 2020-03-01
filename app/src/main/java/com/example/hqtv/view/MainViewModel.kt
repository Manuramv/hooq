package com.example.hqtv.view

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hqtv.models.MoviesResponse
import com.example.hqtv.repo.AppRepo

/**
 * Created by manuramv on 2020-02-29.
 */
class MainViewModel : ViewModel() {
    val appRepo = AppRepo()
    val movieResults: MutableLiveData<MoviesResponse> = MutableLiveData()

    //implementation will do later.
    fun fetchMovieList(){
        appRepo.getMovies(1,{ response ->
            Log.d("manuuuu",response.results.get(18).poster_path)
            movieResults.postValue(response)

        }, {

        })

    }



}

