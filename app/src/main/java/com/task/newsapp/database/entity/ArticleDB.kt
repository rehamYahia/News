package com.task.newsapp.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.task.newsapp.model.Article




@Entity(tableName = "ArticleTable")
class ArticleDB(
    @PrimaryKey(autoGenerate = true)
    var articalId: Int? = null,
    var author: String? = null,
    var content: String? = null,
    var description: String? = null,
    var publishedAt: String? = null,
    var title: String? = null,
    var url: String? = null,
    var urlToImage: String? = null
)
