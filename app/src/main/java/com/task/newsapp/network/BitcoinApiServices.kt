package com.task.newsapp.network

import com.task.newsapp.Constants
import com.task.newsapp.model.BitcoinResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface BitcoinApiServices {

    @GET(Constants.bitcoinEndPoint)
    suspend fun getArticals(): BitcoinResponse
}