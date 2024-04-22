package com.task.newsapp.database.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.task.newsapp.database.entity.ArticleDB

class ArticalConverter {
//    @TypeConverter
//    public fun fromListToString(category:List<ArticleDB>) : String? {
//        val gson = Gson()
//        val type = object : TypeToken<ArticleDB>(){
//        }.type
//        return gson.toJson(category,type)
//    }
//
//    @TypeConverter
//    public fun fromStringToList(string :String): List<ArticleDB>? {
//        val gson = Gson()
//        val type = object : TypeToken<ArticleDB>(){
//        }.type
//        return gson.fromJson(string,type)
//    }

    @TypeConverter
    fun fromArticlesList(articles: List<ArticleDB>?): String? {
        return Gson().toJson(articles)
    }

    @TypeConverter
    fun toArticlesList(articlesString: String?): List<ArticleDB>? {
        return Gson().fromJson(articlesString, object : TypeToken<List<ArticleDB>>() {}.type)
    }
}