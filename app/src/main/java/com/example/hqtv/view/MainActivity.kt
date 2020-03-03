package com.example.hqtv.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hqtv.R
import com.example.hqtv.models.MoviesResponse
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hqtv.commonutils.Constants
import com.example.hqtv.commonutils.NetworkUtils
import com.example.hqtv.customcomponents.HqAlertDialog
import kotlinx.android.synthetic.main.custom_hq_error_dialog.*


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel:MainViewModel
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        showInitialLoadingProgressBar()
        observeList()
        getNowPLayingMovieList();

        btnRetry.setOnClickListener{
            getNowPLayingMovieList()
        }

    }

    private fun getNowPLayingMovieList() {
        if(NetworkUtils.isNetworkAvailable(this)){
            mainViewModel.fetchMovieList();
        }
        else
            showNetworkErrorMessage()
    }

    private fun addImagesToRecyclerView(it: MoviesResponse) {
        var rowViewModels: ArrayList<RowItemViewModel>? = arrayListOf()
            it.results?.map {
                rowViewModels?.add(RowItemViewModel(it))
            }
        rvMovieList.layoutManager = GridLayoutManager(this, Constants.GRID_ITEMS_COUNT)
        movieAdapter = MovieAdapter(rowViewModels!!)
        rvMovieList.adapter = movieAdapter
        hideInitialLoadingProgressBar()
        hideNetworErrorMessage()
    }

    // Observers the mutable list to update recycler view
    private fun observeList() {
        mainViewModel?.movieResults?.observe(this,
            Observer {
                addImagesToRecyclerView(it)
            })
    }

    //this method will show the network error message
    fun showNetworkErrorMessage(){
        hideInitialLoadingProgressBar()
        viewRetry.visibility = View.VISIBLE
    }

    ////this method will hide the network error message
    fun hideNetworErrorMessage(){
        viewRetry.visibility = View.GONE
    }

    //This method will show the progress bar and Loading entertainment msg to user
    fun showInitialLoadingProgressBar(){
        pbMain.isVisible = true
        txtLoadingExperience.visibility = View.VISIBLE
    }

    //This method will hide the progress bar and Loading entertainment msg to user
    fun hideInitialLoadingProgressBar(){
        pbMain.isVisible = false
        txtLoadingExperience.visibility = View.GONE
    }
}
