package com.task.newsapp.repositories


import com.task.newsapp.database.dao.ArticalsDao
import com.task.newsapp.database.db.ArticalDatabase
import com.task.newsapp.database.entity.ArticleDB
import com.task.newsapp.model.AppleResponse
import com.task.newsapp.model.BitcoinResponse
import com.task.newsapp.model.TechCrunchResponse
import com.task.newsapp.network.BitcoinApiServices
import kotlinx.coroutines.flow.Flow


class ArticalRepoImp (private val bitcoinApiServices: BitcoinApiServices , private val articalsDao: ArticalsDao):ArticalRepo{
    //..remote
    override suspend fun getAllBitcoinArtical(): BitcoinResponse {
    return bitcoinApiServices.getArticals()
    }

    override suspend fun getAllAppleArtical(): AppleResponse {
        return bitcoinApiServices.getAppleArtical()
    }

    override suspend fun getAllTechCrunchArtical(): TechCrunchResponse {
       return bitcoinApiServices.getTechCrunch()
    }

    //..local

    override suspend fun insertArticalToDatabase(article: ArticleDB) {
      articalsDao.insert(article)
    }


    override suspend fun getArticalsFromDatabase(): Flow<List<ArticleDB>> {
        return articalsDao.getAllArticles()
    }


}