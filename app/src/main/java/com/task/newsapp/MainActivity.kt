package com.task.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.task.newsapp.ui.theme.NewsAppTheme
import com.task.newsapp.viewmodel.BitcoinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    bitcoinArticals()
                }
            }
        }
    }
}

@Composable
fun bitcoinArticals(viewModel: BitcoinViewModel = viewModel()) {
    val bitCoin by viewModel.Bitcoin.collectAsState()

    LazyColumn {
        bitCoin?.let {
            items(it.articles){artical->
                bitcoinItem(artical.author,artical.title,artical.description,artical.url,artical.publishedAt)
            }
        }

    }
}

@Composable
fun bitcoinItem(
    auther: String,
    title: String,
    description: String,
    url: String,
    publishedAt: String
) {
    Row {
//        Image(
//            modifier = Modifier
//                .size(120.dp)
//                .padding(5.dp),
//            painter = painterResource(id = TODO()),
//            contentDescription = "icon"
//        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterVertically)
        ) {
            Text(
                text = "Auther: $auther", modifier = Modifier.padding(5.dp),
                fontSize = MaterialTheme.typography.displayMedium.fontSize
            )
            Text(
                text = "Title: $title", modifier = Modifier.padding(5.dp),
                fontSize = MaterialTheme.typography.displayMedium.fontSize
            )
            Text(
                text = "Description: $description", modifier = Modifier.padding(5.dp),
                fontSize = MaterialTheme.typography.displayMedium.fontSize
            )
            Text(
                text = "PublishedAt: $publishedAt", modifier = Modifier.padding(5.dp),
                fontSize = MaterialTheme.typography.displayMedium.fontSize
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NewsAppTheme {

    }
}