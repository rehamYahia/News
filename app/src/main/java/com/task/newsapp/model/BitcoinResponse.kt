package com.task.newsapp.model

data class BitcoinResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)