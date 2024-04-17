package com.task.newsapp.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.newsapp.model.BitcoinResponse
import com.task.newsapp.repositories.BitcoinRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BitcoinViewModel @Inject constructor(private val bitcoinRepo: BitcoinRepo): ViewModel(){
    private val _Bitcoin : MutableStateFlow<BitcoinResponse?> = MutableStateFlow(null)
    val Bitcoin : MutableStateFlow<BitcoinResponse?> = _Bitcoin


    private suspend fun getBitcoin() {
        viewModelScope.launch {
            _Bitcoin.value = bitcoinRepo.getAllBitcoinArtical()
        }
    }
}