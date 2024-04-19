package com.task.newsapp.di

import com.task.newsapp.network.BitcoinApiServices
import com.task.newsapp.repositories.BitcoinRepo
import com.task.newsapp.repositories.BitcoinRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideBitcoinRepo(bitcoinApiServices: BitcoinApiServices):BitcoinRepo{
        return BitcoinRepoImp(bitcoinApiServices)
    }

}