package com.example.hqtv.view

import androidx.lifecycle.ViewModel
import com.example.hqtv.models.Result
import com.example.hqtv.repo.AppRepo
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.example.hqtv.repo.PostsDataSource
import kotlinx.coroutines.Dispatchers


/**
 * Created by manuramv on 2020-02-29.
 */
class MainViewModel : ViewModel() {
    //this viewmodel configure the paging library and communicate back-forth between main activity and repo.

    val appRepo = AppRepo()
    var postsLiveData  :LiveData<PagedList<Result>>
    lateinit var postsDataSource : PostsDataSource

    init {
        val config = PagedList.Config.Builder().setPageSize(1).setEnablePlaceholders(false).build()
        postsLiveData  = initializedPagedListBuilder(config).build()
    }


    fun getMovies():LiveData<PagedList<Result>> = postsLiveData



    //Initalize pagelist library. We are not using the scroll list listner to load the next item.
    // PAging libarary seems to be very effective one.
    private fun initializedPagedListBuilder(config: PagedList.Config): LivePagedListBuilder<String, Result> {
        val dataSourceFactory = object : DataSource.Factory<String, Result>() {
            override fun create(): DataSource<String, Result> {
                postsDataSource = PostsDataSource(appRepo, Dispatchers.IO)
                return postsDataSource
            }
        }
        return LivePagedListBuilder<String, Result>(dataSourceFactory, config)
    }
}

