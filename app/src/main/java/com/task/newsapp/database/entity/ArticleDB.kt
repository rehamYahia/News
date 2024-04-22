package com.task.newsapp.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ArticleTable")
data class ArticleDB(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "articalId")
    val articalId: Int,
    @ColumnInfo(name = "author")
    var author: String? = null,
    @ColumnInfo(name = "content")
    var content: String? = null,
    @ColumnInfo(name = "description")
    var description: String? = null,
    @ColumnInfo(name = "publishedAt")
    var publishedAt: String? = null,
    @ColumnInfo(name = "title")
    var title: String? = null,
    @ColumnInfo(name = "url")
    var url: String? = null,
    @ColumnInfo(name = "urlToImage")
    var urlToImage: String? = null
)
