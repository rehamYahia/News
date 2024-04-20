package com.task.newsapp.model

data class AppleResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)