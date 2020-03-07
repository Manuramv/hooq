package com.example.hqtv.repo

import com.example.hqtv.commonutils.Constants
import com.example.hqtv.models.MoviesResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Response
import java.util.*

/**
 * Created by manuramv on 2020-02-24.
 */
class AppRepo {
    var apiServiceInterface:APIServiceInterface?=null
    init {
        apiServiceInterface = APIClient.getApiClientInterface().create(APIServiceInterface::class.java)
    }

    fun getMovies(pageIndex:Int, onSuccess: (MoviesResponse) ->Unit, onError: (String) -> Unit){
        apiServiceInterface?.getNowPlayingMovies(pageIndex,Constants.TMDB_API_KEY)
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(
                {
                    result -> onSuccess.invoke(result)
                },
                {
                    error -> onError.invoke(error.toString())
                }
            )

    }
}
