package com.example.hqtv.view

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * Created by manuramv on 2020-03-08.
 */
@RunWith(JUnit4::class)
class MainViewModelTest{
    var mainViewModel = MainViewModel()

    @Test
    fun `fetch the now playing movies API`(){
        Assert.assertNotNull( mainViewModel.getMovies())
    }

}