package com.example.hqtv.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.hqtv.R
import com.example.hqtv.models.MoviesResponse
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.GridLayoutManager




class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel:MainViewModel
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        observeList()
        getNowPLayingMovieList();
    }

    private fun getNowPLayingMovieList() {
        mainViewModel.fetchMovieList();
    }

    private fun addImagesToRecyclerView(it: MoviesResponse) {
        movieAdapter = MovieAdapter(it)
        rvMovieList.layoutManager = GridLayoutManager(this, 3)
        rvMovieList.adapter = movieAdapter

    }

    // Observers the mutable list to update recycler view
    private fun observeList() {
        mainViewModel?.movieResults?.observe(this,
            Observer {
                addImagesToRecyclerView(it)
            })
    }

}
