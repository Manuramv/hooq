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
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import androidx.core.os.HandlerCompat.postDelayed
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

import android.os.Handler
import android.util.Log


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel:MainViewModel
     val movieAdapter = MovieAdapter()
    val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        showInitialLoadingProgressBar()
        initializeRecyclerView()

        btnRetry.setOnClickListener{
            observeLiveData()
        }

        //Adding the 2 seconds delay to show the loading experience
        val handler = Handler()
        handler.postDelayed(Runnable {
            observeLiveData()
        }, 2000)

    }


    private fun initializeRecyclerView() {
        rvMovieList.layoutManager = GridLayoutManager(this, Constants.GRID_ITEMS_COUNT)
        rvMovieList.adapter = movieAdapter
    }


    private fun observeLiveData() {
        //observe live data emitted by view model
        if(NetworkUtils.isNetworkAvailable(this)){
            mainViewModel.getPosts()?.observe(this, Observer {
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
