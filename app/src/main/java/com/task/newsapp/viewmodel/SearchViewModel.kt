package com.task.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.newsapp.model.AllResponse
import com.task.newsapp.repositories.ArticalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val articalRepo: ArticalRepo):ViewModel(){
    private val _SearchArtical : MutableStateFlow<AllResponse?> = MutableStateFlow(null)
    val SearchArtical : MutableStateFlow<AllResponse?> = _SearchArtical
     suspend fun getDataSearch(search:String , api_key:String){
        viewModelScope.launch {
        _SearchArtical.value = articalRepo.searchForArtical(search , api_key)
        }
    }
}