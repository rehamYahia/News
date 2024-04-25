package com.task.newsapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.newsapp.constant.Constants
import com.task.newsapp.model.AllResponse
import com.task.newsapp.repositories.ArticalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppleViewModel @Inject constructor(private val articalRepo: ArticalRepo):ViewModel() {

    private val _Apple: MutableStateFlow<AllResponse?> = MutableStateFlow(null)
    val Apple  get() = _Apple

init {
    viewModelScope.launch {
        getAppleArtical(Constants.APPLE_Q  , Constants.APPLE_FTOM ,  Constants.APPLE_TO , Constants.APPLE_SORTED_BY , Constants.API_KEY)
    }

}
    private suspend fun getAppleArtical(q:String,from:String ,to:String ,sortedBy:String , apiKey:String){
        viewModelScope.launch {
            _Apple.value = articalRepo.getAllAppleArtical(q , from , to , sortedBy , apiKey)
        }
    }
}