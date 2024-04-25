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
class BitcoinViewModel @Inject constructor(private val articalRepo: ArticalRepo): ViewModel(){
    private val _Bitcoin : MutableStateFlow<AllResponse?> = MutableStateFlow(null)
    val Bitcoin : MutableStateFlow<AllResponse?> = _Bitcoin
init {
    viewModelScope.launch {
        getBitcoin(Constants.BITCOIN_Q,Constants.API_KEY)
    }

}

    private suspend fun getBitcoin(q:String , aapiKey:String) {
        viewModelScope.launch {
            _Bitcoin.value = articalRepo.getAllBitcoinArtical(q, aapiKey)
        }
    }
}