package com.task.newsapp.repositories

import com.task.newsapp.model.BitcoinResponse
import kotlinx.coroutines.flow.Flow


interface BitcoinRepo {
    suspend fun getAllBitcoinArtical():Flow<BitcoinResponse>
}