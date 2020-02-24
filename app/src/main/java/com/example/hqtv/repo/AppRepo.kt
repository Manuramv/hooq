package com.example.hqtv.repo

/**
 * Created by manuramv on 2020-02-24.
 */
class AppRepo {
    var apiServiceInterface:APIServiceInterface?=null
    init {
        apiServiceInterface = APIClient.getApiClientInterface().create(APIServiceInterface::class.java)
    }
}
