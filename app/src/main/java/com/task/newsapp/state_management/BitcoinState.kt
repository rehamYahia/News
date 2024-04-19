package com.task.newsapp.state_management

import com.task.newsapp.model.BitcoinResponse

sealed class BitcoinState {
    object Loading : BitcoinState()
    data class Sucess(val bitcoinResponse: BitcoinResponse) : BitcoinState()
    data class Error(val error: Throwable) : BitcoinState()
}