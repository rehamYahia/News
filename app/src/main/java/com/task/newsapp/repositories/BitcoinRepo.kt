package com.task.newsapp.repositories

import com.task.newsapp.model.Article
import com.task.newsapp.model.BitcoinResponse
import kotlinx.coroutines.flow.Flow


interface BitcoinRepo {
    suspend fun getAllBitcoinArtical():BitcoinResponse
}