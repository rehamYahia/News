package com.task.newsapp.model

data class AllResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)