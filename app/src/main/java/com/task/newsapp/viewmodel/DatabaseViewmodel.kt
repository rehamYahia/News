package com.task.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.newsapp.database.entity.ArticleDB
import com.task.newsapp.repositories.ArticalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DatabaseViewmodel @Inject constructor(private val articalRepo: ArticalRepo) :ViewModel(){

    init {
        viewModelScope.launch {
            getFavouritArtical()
        }
    }

    private val _FavouritArtical:MutableStateFlow<List<ArticleDB>?> = MutableStateFlow(null)
    val FavouritArtical :StateFlow<List<ArticleDB>?> = _FavouritArtical



    private suspend fun getFavouritArtical(){
        viewModelScope.launch() {
             articalRepo.getArticalsFromDatabase().collect{artical->
                _FavouritArtical.value = artical
            }
        }
    }


    suspend fun addArticalToRoom( vararg articles: ArticleDB){
        articalRepo.insertArticalToDatabase(*articles)
    }

    suspend fun deleteArtical(articalid:Int){
        articalRepo.deletArticalFromDatabase(articalid)
    }

}