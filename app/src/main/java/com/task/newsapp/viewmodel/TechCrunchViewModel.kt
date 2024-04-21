package com.task.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.newsapp.model.AppleResponse
import com.task.newsapp.model.TechCrunchResponse
import com.task.newsapp.repositories.ArticalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TechCrunchViewModel @Inject constructor(val articalRepo: ArticalRepo):ViewModel(){
    private val _TechCrunch: MutableStateFlow<TechCrunchResponse?> = MutableStateFlow(null)
    val TechCrunch : StateFlow<TechCrunchResponse?> get() = _TechCrunch

    init {
        viewModelScope.launch {
            getAppleArtical()
        }
    }
    suspend fun getAppleArtical(){
        viewModelScope.launch {
            _TechCrunch.value = articalRepo.getAllTechCrunchArtical()
        }
    }
}