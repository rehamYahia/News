package com.task.newsapp.repositories


import com.task.newsapp.database.db.ArticalDatabase
import com.task.newsapp.database.entity.ArticleDB
import com.task.newsapp.database.entity.DatabaseResponse
import com.task.newsapp.model.AppleResponse
import com.task.newsapp.model.BitcoinResponse
import com.task.newsapp.model.TechCrunchResponse


interface ArticalRepo {
    //..remote
    suspend fun getAllBitcoinArtical():BitcoinResponse

    suspend fun getAllAppleArtical():AppleResponse

    suspend fun getAllTechCrunchArtical():TechCrunchResponse

    //..local
    suspend fun insertArticalToDatabase(articalDB: ArticleDB)
    suspend fun getArticalsFromDatabase(): DatabaseResponse


}