package com.task.newsapp.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.task.newsapp.database.converters.ArticalConverter
import com.task.newsapp.database.dao.ArticalsDao
import com.task.newsapp.database.entity.ArticleDB
import com.task.newsapp.database.entity.DatabaseResponse

@Database(entities = [ DatabaseResponse::class , ArticleDB::class  ] ,  version = 1 , exportSchema = false)
@TypeConverters(ArticalConverter::class)
abstract class ArticalDatabase : RoomDatabase(){
    abstract fun getArticalDao(): ArticalsDao
}