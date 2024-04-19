package com.task.newsapp.repositories


import com.task.newsapp.model.BitcoinResponse
import dagger.Provides



interface BitcoinRepo {
    suspend fun getAllBitcoinArtical():BitcoinResponse
}