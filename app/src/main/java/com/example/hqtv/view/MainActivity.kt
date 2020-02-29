package com.example.hqtv.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.hqtv.R

class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        addImagesToRecyclerView();
        getNowPLayingMovieList();
    }

    private fun getNowPLayingMovieList() {
        mainViewModel.fetchMovieList();
        addImagesToRecyclerView();
    }

    private fun addImagesToRecyclerView() {

    }

}
