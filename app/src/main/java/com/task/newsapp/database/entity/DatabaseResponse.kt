package com.task.newsapp.database.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.task.newsapp.model.Article

@Entity(tableName = "ResponseTable")
data class DatabaseResponse(


    @ColumnInfo(name = "articles")
    val articles: List<ArticleDB>? = null
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Int? = null
}



