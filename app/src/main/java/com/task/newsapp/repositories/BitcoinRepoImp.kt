package com.task.newsapp.repositories

import com.task.newsapp.model.Article
import com.task.newsapp.model.BitcoinResponse
import com.task.newsapp.network.BitcoinApiServices



class BitcoinRepoImp (private val bitcoinApiServices: BitcoinApiServices):BitcoinRepo{
    override suspend fun getAllBitcoinArtical(): BitcoinResponse {
    return bitcoinApiServices.getArticals()
    }

}