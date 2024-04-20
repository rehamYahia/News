package com.task.newsapp.model

data class TechCrunchResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)