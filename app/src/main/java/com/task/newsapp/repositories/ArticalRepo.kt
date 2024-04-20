package com.task.newsapp.repositories


import com.task.newsapp.model.AppleResponse
import com.task.newsapp.model.BitcoinResponse
import com.task.newsapp.model.TechCrunchResponse


interface ArticalRepo {
    suspend fun getAllBitcoinArtical():BitcoinResponse

    suspend fun getAllAppleArtical():AppleResponse

    suspend fun getAllTechCrunchArtical():TechCrunchResponse
}