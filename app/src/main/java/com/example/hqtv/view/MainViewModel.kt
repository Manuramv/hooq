package com.example.hqtv.view

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.hqtv.repo.AppRepo

/**
 * Created by manuramv on 2020-02-29.
 */
class MainViewModel : ViewModel() {
    val appRepo = AppRepo()

    //implementation will do later.
    fun fetchMovieList(){
        appRepo.getMovies(1,{ response ->
            Log.d("manuuuu",response.results.get(18).poster_path)

        }, {

        })

    }

}

