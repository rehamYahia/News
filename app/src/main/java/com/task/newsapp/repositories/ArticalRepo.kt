package com.task.newsapp.repositories


import com.task.newsapp.database.db.ArticalDatabase
import com.task.newsapp.database.entity.ArticleDB
import com.task.newsapp.model.AppleResponse
import com.task.newsapp.model.BitcoinResponse
import com.task.newsapp.model.TechCrunchResponse
import kotlinx.coroutines.flow.Flow


interface ArticalRepo {
    //..remote
    suspend fun getAllBitcoinArtical():BitcoinResponse

    suspend fun getAllAppleArtical():AppleResponse

    suspend fun getAllTechCrunchArtical():TechCrunchResponse

    //..local
    suspend fun insertArticalToDatabase(article: ArticleDB)
    suspend fun getArticalsFromDatabase():Flow<List<ArticleDB>>


}