package com.task.newsapp.repositories


import com.task.newsapp.database.dao.ArticalsDao
import com.task.newsapp.database.entity.ArticleDB
import com.task.newsapp.model.AllResponse
import com.task.newsapp.network.NetworkApiServices
import kotlinx.coroutines.flow.Flow


class ArticalRepoImp (private val bitcoinApiServices: NetworkApiServices, private val articalsDao: ArticalsDao):ArticalRepo{
    //..remote
    override suspend fun getAllBitcoinArtical(q:String , aapiKey:String): AllResponse {
    return bitcoinApiServices.getArticals(q , aapiKey)
    }

    override suspend fun getAllAppleArtical(q:String,from:String ,to:String ,sortedBy:String , apiKey:String): AllResponse {
        return bitcoinApiServices.getAppleArtical(q , from , to , sortedBy , apiKey)
    }

    override suspend fun getAllTechCrunchArtical(domains:String,apiKey:String): AllResponse {
       return bitcoinApiServices.getTechCrunch(domains , apiKey)
    }


    override suspend fun searchForArtical(search: String, aapiKey:String): AllResponse {
        return bitcoinApiServices.searchNews(search, aapiKey)
    }


    //..local

    override suspend fun insertArticalToDatabase(vararg article: ArticleDB) {
        for(articals in article){
            val existingArticle = articals.author?.let { articals.title?.let { it1 ->
                articals.content?.let { it2 ->
                    articals.description?.let { it3 ->
                        articals.url?.let { it4 ->
                            articals.urlToImage?.let { it5 ->
                                articals.publishedAt?.let { it6 ->
                                    articalsDao.findArtical(it,
                                        it1, it2, it3, it4, it5, it6
                                    )
                                }
                            }
                        }
                    }
                }
            } }
            if (existingArticle == null) {
                articalsDao.insert( *article)
            } else {

            }
        }


    }


    override suspend fun getArticalsFromDatabase(): Flow<List<ArticleDB>> {
        return articalsDao.getAllArticles()
    }

//    override suspend fun getArticleById(article: ArticleDB):Int {
//      return article.articalId
//    }

    override suspend fun deletArticalFromDatabase(articalid: Int) {
        articalsDao.delete(articalid)
    }


}