package com.task.newsapp.di

import com.task.newsapp.database.dao.ArticalsDao
import com.task.newsapp.network.NetworkApiServices
import com.task.newsapp.repositories.ArticalRepo
import com.task.newsapp.repositories.ArticalRepoImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBitcoinRepo(bitcoinApiServices: NetworkApiServices, articalsDao: ArticalsDao):ArticalRepo{
        return ArticalRepoImp(bitcoinApiServices, articalsDao)
    }

}