package com.task.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.newsapp.constant.Constants
import com.task.newsapp.model.AllResponse
import com.task.newsapp.repositories.ArticalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TechCrunchViewModel @Inject constructor(val articalRepo: ArticalRepo):ViewModel(){
    private val _TechCrunch: MutableStateFlow<AllResponse?> = MutableStateFlow(null)
    val TechCrunch : StateFlow<AllResponse?> get() = _TechCrunch

    init {
        viewModelScope.launch {
            getAppleArtical(Constants.TECHCRUNCH_DOMAIN , Constants.API_KEY)
        }
    }
    suspend fun getAppleArtical(domains:String,apiKey:String){
        viewModelScope.launch {
            _TechCrunch.value = articalRepo.getAllTechCrunchArtical(domains , apiKey)
        }
    }
}