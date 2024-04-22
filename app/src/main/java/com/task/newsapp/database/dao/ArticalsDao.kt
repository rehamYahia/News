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
    suspend fun insert(article: ArticleDB)

    @Delete
    suspend fun delete(article: ArticleDB)


}