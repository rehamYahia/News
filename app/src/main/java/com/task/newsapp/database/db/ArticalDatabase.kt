package com.task.newsapp.database.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.task.newsapp.database.converters.ArticalConverter
import com.task.newsapp.database.dao.ArticalsDao
import com.task.newsapp.database.entity.ArticleDB



@Database(entities = [  ArticleDB::class  ] ,  version = 1 , exportSchema = false)

abstract class ArticalDatabase : RoomDatabase(){
    abstract fun getArticalDao(): ArticalsDao
}