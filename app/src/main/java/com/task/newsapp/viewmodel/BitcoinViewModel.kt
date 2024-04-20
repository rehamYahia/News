package com.task.newsapp.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.newsapp.model.BitcoinResponse
import com.task.newsapp.repositories.ArticalRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BitcoinViewModel @Inject constructor(private val articalRepo: ArticalRepo): ViewModel(){
    private val _Bitcoin : MutableStateFlow<BitcoinResponse?> = MutableStateFlow(null)
    val Bitcoin : MutableStateFlow<BitcoinResponse?> = _Bitcoin
init {
    viewModelScope.launch {
        getBitcoin()
    }

}

    private suspend fun getBitcoin() {
        viewModelScope.launch {
            _Bitcoin.value = articalRepo.getAllBitcoinArtical()
        }
    }
}