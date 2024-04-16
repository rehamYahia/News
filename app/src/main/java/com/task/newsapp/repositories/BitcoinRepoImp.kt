package com.task.newsapp.repositories

import com.task.newsapp.model.BitcoinResponse
import com.task.newsapp.network.BitcoinApiServices
import kotlinx.coroutines.flow.Flow


class BitcoinRepoImp (private val bitcoinApiServices: BitcoinApiServices):BitcoinRepo{
    override suspend fun getAllBitcoinArtical(): Flow<BitcoinResponse> {
      return  bitcoinApiServices.getArticals()
    }

}