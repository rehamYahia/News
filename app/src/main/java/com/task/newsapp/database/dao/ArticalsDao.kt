package com.task.newsapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.task.newsapp.database.entity.ArticleDB
import com.task.newsapp.database.entity.DatabaseResponse

@Dao
interface ArticalsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertArticalToDatabase(articleDB: ArticleDB)

    @Query("SELECT * FROM ArticleTable")
    fun getArticalFromDatabase() : DatabaseResponse


}