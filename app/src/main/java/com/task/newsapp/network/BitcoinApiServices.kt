package com.task.newsapp.network

import com.task.newsapp.constant.Constants
import com.task.newsapp.model.AppleResponse
import com.task.newsapp.model.BitcoinResponse
import com.task.newsapp.model.TechCrunchResponse
import retrofit2.http.GET

interface BitcoinApiServices {

    @GET(Constants.bitcoinEndPoint)
    suspend fun getArticals(): BitcoinResponse

    @GET(Constants.appleArticalEndPoint)
    suspend fun getAppleArtical(): AppleResponse

    @GET(Constants.TechCrunchEndPoint)
    suspend fun getTechCrunch():TechCrunchResponse
}