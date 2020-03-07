package com.example.hqtv.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.paging.PageKeyedDataSource
import com.example.hqtv.commonutils.Constants
import com.example.hqtv.models.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext





/**
 * Created by manuramv on 2020-03-04.
 */
class PostsDataSource(val appRepo: AppRepo, coroutineContext: CoroutineContext) : PageKeyedDataSource<String, Result>() {
    val TAG = PostsDataSource::class.java.canonicalName
    private var pageNumber =1;
    private val job = Job()
    private val scope = CoroutineScope(coroutineContext + job)
    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, Result>) {
        Log.i(TAG,"loadapi  initial::"+pageNumber)
        scope.launch {
            try {
                val response = appRepo.apiServiceInterface?.getNewMoviess(pageNumber++,Constants.TMDB_API_KEY)
                        val listing = response?.results
                        callback.onResult(response?.results!! ,"1","20")
            }catch (exception : Exception){
                Log.e("PostsDataSource ", "Failed to fetch data!")
                //callback.onError(exception);
            }

        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, Result>) {
        Log.i(TAG,"loadapi  loadAfter::"+pageNumber)
        scope.launch {
            try {
                val response = appRepo.apiServiceInterface?.getNewMoviess(pageNumber++, Constants.TMDB_API_KEY)
                val listing = response?.results
                callback.onResult(response?.results!!, "1")
            } catch (exception: Exception) {
                Log.e("PostsData", "Failed to fetch data!")
               // callback.onError(exception);
            }
        }
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, Result>) {
    }

}