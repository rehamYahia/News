package com.task.newsapp.network

import com.task.newsapp.constant.Constants
import com.task.newsapp.model.AllResponse
import retrofit2.http.GET
import retrofit2.http.Query


interface NetworkApiServices {
    @GET(Constants.END_POINT)
    suspend fun getArticals(@Query ("q") q:String,@Query("apiKey") apiKey:String): AllResponse

    @GET(Constants.END_POINT)
    suspend fun getAppleArtical(@Query ("q") q:String,@Query ("from") from:String,@Query ("to") to:String,@Query ("sortBy") sortBy:String,@Query("apiKey") apiKey:String): AllResponse

    @GET(Constants.END_POINT)
    suspend fun getTechCrunch(@Query ("domains") domains:String ,@Query("apiKey") apiKey:String  ):AllResponse



    @GET(Constants.END_POINT)
    suspend fun searchNews(@Query("q") q: String, @Query("apiKey") apiKey: String): AllResponse
}

//@Query("pageSize")pageSize:Int , @Query("page") page  :Int