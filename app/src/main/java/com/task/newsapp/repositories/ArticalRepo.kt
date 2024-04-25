package com.task.newsapp.repositories


import com.task.newsapp.database.entity.ArticleDB
import com.task.newsapp.model.AllResponse
import kotlinx.coroutines.flow.Flow


interface ArticalRepo {
    //..remote
    suspend fun getAllBitcoinArtical(q:String , apiKey:String):AllResponse

    suspend fun getAllAppleArtical(q:String,from:String ,to:String ,sortedBy:String , apiKey:String):AllResponse

    suspend fun getAllTechCrunchArtical(domains:String,apiKey:String):AllResponse
    suspend fun searchForArtical(search:String, apiKey:String):AllResponse

    //..local
    suspend fun insertArticalToDatabase(vararg article: ArticleDB)
    suspend fun getArticalsFromDatabase():Flow<List<ArticleDB>>


//    suspend fun getArticleById(article: ArticleDB):Int
    suspend fun deletArticalFromDatabase(articalid:Int)




}