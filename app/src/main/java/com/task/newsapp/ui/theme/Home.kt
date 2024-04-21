package com.task.newsapp.ui.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun HomeScreen(modifier: Modifier = Modifier.background(Color.Black)) {

    Column( modifier.padding(20.dp)) {
        Spacer( modifier.padding(vertical = 10.dp))
        search()
        HomeSection("Apple Articals") {
            AppleArticals()
        }
        HomeSection("Tech Crunch Articals") {
            TechCrunchArticals()
        }

        HomeSection("Bitcoin Articals") {
            BitcoinArticals()
        }
    }

}


@Composable
fun HomeSection(title: String, content: @Composable () -> Unit) {
    Column {
        Text(
            text = title.uppercase(),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp),
            color = Color.Gray
        )
        content()
    }
}