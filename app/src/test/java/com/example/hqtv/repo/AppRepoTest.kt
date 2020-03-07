package com.example.hqtv.repo

import io.mockk.coEvery
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.MockitoAnnotations
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.plugins.RxAndroidPlugins
import org.junit.BeforeClass
import android.graphics.Movie
import kotlinx.coroutines.runBlocking


/**
 * Created by manuramv on 2020-03-07.
 */
@RunWith(JUnit4::class)
class AppRepoTest{
    companion object{
        fun setupTest() {
            RxAndroidPlugins.setInitMainThreadSchedulerHandler {  Schedulers.trampoline() }
        }
    }

    @Before
    open fun beforeEach() {
        MockitoAnnotations.initMocks(this)
        setupTest()
    }


    @Test
    fun `get Movie list for page 1 from server positive scenario`(){

            AppRepo().getMovies(1,{
                Assert.assertTrue(it?.results != null)
            },{ assert(false)})

    }
   @Test
    fun `get Movie list for page 2 from server positive scenario`(){
        AppRepo().getMovies(2,{
            Assert.assertTrue(it?.results != null)
        },{ assert(false)})
    }

    @Test
    fun `service should not fail even if page is -1`(){
        AppRepo().getMovies(-1,{
            Assert.assertTrue(it?.results != null)
        },{ assert(false)})
    }
    @Test
    fun `service should not fail even if page is 0`(){
        AppRepo().getMovies(0,{
            Assert.assertTrue(it?.results != null)
        },{ assert(false)})
    }
}