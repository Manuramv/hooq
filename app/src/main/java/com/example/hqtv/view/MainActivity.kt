package com.example.hqtv.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hqtv.R
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hqtv.commonutils.Constants
import com.example.hqtv.commonutils.NetworkUtils
import kotlinx.android.synthetic.main.custom_hq_error_dialog.*
import io.reactivex.disposables.CompositeDisposable

import android.os.Handler


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel:MainViewModel
     val movieAdapter = MovieAdapter()
    val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        //Calling the progress bar immediately after user launchign the app.
        showInitialLoadingProgressBar()
        //Init Recyclerview
        initializeRecyclerView()

        //If internet is not there when there is no item to show, we will show a special error as per requirement and each time we re-trigger the API
        //when user clicks retry.
        btnRetry.setOnClickListener{
            observeLiveData()
        }

        //Adding the 2 seconds delay to show the loading experience progress bar(Since it's a sample project I put the delay deliberately).
        val handler = Handler()
        handler.postDelayed(Runnable {
            observeLiveData()
        }, 2000)

    }


    private fun initializeRecyclerView() {
        rvMovieList.layoutManager = GridLayoutManager(this, Constants.GRID_ITEMS_COUNT)
        rvMovieList.adapter = movieAdapter
    }


    //Observing for data changes.
    private fun observeLiveData() {
        //observe live data emitted by view model
        if(NetworkUtils.isNetworkAvailable(this)){
            mainViewModel.getMovies()?.observe(this, Observer {
                movieAdapter.submitList(it)
                hideInitialLoadingProgressBar()
                hideNetworErrorMessage()
            })
        }
        else {
            showNetworkErrorMessage()
        }

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
