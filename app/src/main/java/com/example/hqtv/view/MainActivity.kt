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
import com.example.hqtv.commonutils.NetworkUtils
import com.example.hqtv.customcomponents.HqAlertDialog


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel:MainViewModel
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        showInitialLoading()
        observeList()
        getNowPLayingMovieList();

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
                rowViewModels?.add(RowItemViewModel(it))}
        rvMovieList.layoutManager = GridLayoutManager(this, 3)
        movieAdapter = MovieAdapter(rowViewModels!!)
        rvMovieList.adapter = movieAdapter
        hideInitialLoading()
    }

    // Observers the mutable list to update recycler view
    private fun observeList() {
        mainViewModel?.movieResults?.observe(this,
            Observer {
                addImagesToRecyclerView(it)
            })
    }

    //progressbar
    fun showNetworkErrorMessage(){
        HqAlertDialog(this).errorAlertDialog("error msg",{
            mainViewModel.fetchMovieList();
        })
    }

    fun showInitialLoading(){
        pbMain.isVisible = true
        txtLoadingExperience.visibility = View.VISIBLE
    }

    fun hideInitialLoading(){
        pbMain.isVisible = false
        txtLoadingExperience.visibility = View.GONE
    }
}
