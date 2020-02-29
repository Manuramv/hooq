package com.example.hqtv.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hqtv.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addImagesToRecyclerView();
    }

    private fun addImagesToRecyclerView() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
