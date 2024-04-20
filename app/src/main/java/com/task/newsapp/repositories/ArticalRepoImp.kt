package com.task.newsapp.repositories


import com.task.newsapp.model.AppleResponse
import com.task.newsapp.model.BitcoinResponse
import com.task.newsapp.model.TechCrunchResponse
import com.task.newsapp.network.BitcoinApiServices



class ArticalRepoImp (private val bitcoinApiServices: BitcoinApiServices):ArticalRepo{
    override suspend fun getAllBitcoinArtical(): BitcoinResponse {
    return bitcoinApiServices.getArticals()
    }

    override suspend fun getAllAppleArtical(): AppleResponse {
        return bitcoinApiServices.getAppleArtical()
    }

    override suspend fun getAllTechCrunchArtical(): TechCrunchResponse {
       return bitcoinApiServices.getTechCrunch()
    }

}