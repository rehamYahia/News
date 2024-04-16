package com.task.newsapp.network

import com.task.newsapp.model.BitcoinResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface BitcoinApiServices {

    @GET("v2/everything")
    suspend fun getArticals(): Flow<BitcoinResponse>
}