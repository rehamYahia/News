package com.task.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.newsapp.model.AppleResponse
import com.task.newsapp.repositories.ArticalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppleViewModel @Inject constructor(val articalRepo: ArticalRepo):ViewModel() {

    private val _Apple: MutableStateFlow<AppleResponse?> = MutableStateFlow(null)
    val Apple :StateFlow<AppleResponse?> get() = _Apple


    suspend fun getAppleArtical(){
        viewModelScope.launch {
            _Apple.value = articalRepo.getAllAppleArtical()
        }
    }
}