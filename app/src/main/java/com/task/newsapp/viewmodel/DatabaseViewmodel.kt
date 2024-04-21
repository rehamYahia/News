package com.task.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import com.task.newsapp.database.entity.ArticleDB
import com.task.newsapp.database.entity.DatabaseResponse
import com.task.newsapp.repositories.ArticalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject


@HiltViewModel
class DatabaseViewmodel @Inject constructor(private val articalRepo: ArticalRepo) :ViewModel(){

    private val _articalList:MutableStateFlow<DatabaseResponse?> = MutableStateFlow(null)
    val articalList get() = _articalList
    suspend fun getDataFromRoom(){
        _articalList.value = articalRepo.getArticalsFromDatabase()
    }

    suspend fun addArticalToRoom(articleDB: ArticleDB){
        articalRepo.insertArticalToDatabase(articleDB)
    }
}