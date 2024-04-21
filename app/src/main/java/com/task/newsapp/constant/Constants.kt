package com.task.newsapp.constant

class Constants {
    companion object{
        const val bitcoinEndPoint = "/v2/everything?q=bitcoin&apiKey=4ddc8023e6644a008f1493f146ea1380"
        const val appleArticalEndPoint ="/v2/everything?q=apple&from=2024-04-15&to=2024-04-15&sortBy=popularity&apiKey=4ddc8023e6644a008f1493f146ea1380"
        const val TechCrunchEndPoint  = "v2/everything?domains=techcrunch.com,thenextweb.com&apiKey=4ddc8023e6644a008f1493f146ea1380\n"
        const val baseURL = "https://newsapi.org"
    }
}