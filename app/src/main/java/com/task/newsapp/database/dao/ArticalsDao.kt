package com.task.newsapp.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.task.newsapp.database.entity.ArticleDB
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticalsDao {
    @Query("SELECT * FROM ArticleTable")
    fun getAllArticles(): Flow<List<ArticleDB>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg article: ArticleDB)

    @Query("DELETE FROM ArticleTable WHERE articalid = :articleId")
    suspend fun delete(articleId: Int)

    @Query("SELECT * FROM ArticleTable WHERE author = :author AND title = :title AND content = :content AND description = :description AND url = :url AND urlToImage = :urlToImage And publishedAt =:publishedAt ")
    suspend fun findArtical(author: String, title: String , content:String, description:String , url:String  , urlToImage:String , publishedAt:String): ArticleDB?


}