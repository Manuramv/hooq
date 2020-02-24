package com.example.hqtv.repo

import com.example.hqtv.commonutils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class APIClient {
    companion object{
        var retrofit: Retrofit ?=null
        fun getApiClientInterface() : Retrofit {

            val logging =  HttpLoggingInterceptor();
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder().addNetworkInterceptor(logging).build()


            val retrofit = retrofit2.Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .client(okHttpClient)
                .build()

            return retrofit
        }
    }

}