package com.task.newsapp.ui.theme

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.task.newsapp.viewmodel.BitcoinViewModel

@Composable
fun BitcoinArticals(viewModel: BitcoinViewModel = hiltViewModel()) {
    val bitcoin by remember { viewModel.Bitcoin }.collectAsState()
    val context = LocalContext.current
    LazyColumn() {
        bitcoin?.let {
            try {
                items(it.articles){ artical->
                    BitcoinItem(artical.author,artical.title,artical.description,artical.urlToImage,artical.publishedAt)
                }

            }catch (e:Exception){
                Toast.makeText(context , e.message.toString() , Toast.LENGTH_LONG).show()
            }
        }
    }
}



@Composable
fun BitcoinItem(
    auther: String? = null,
    title: String? = null,
    description: String? = null,
    urlToImage: String? = null,
    publishedAt: String? = null,
)
{
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.background(Color.Green).paddingFromBaseline(16.dp)

    ) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter =  rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = urlToImage)
                        .apply(block = fun ImageRequest.Builder.() {
                            transformations()
                        }).build()
                ),
                contentDescription = null,
                modifier = Modifier.width(100.dp).height(100.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = "Auther: $auther",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.h6,


                    )
                Text(
                    text = "Title: $title",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.h6,


                    )
                Text(
                    text = "Description:$description ",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.h6,


                    )
                Text(
                    text = "PublishedAt: $publishedAt",
                    modifier = Modifier.padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.h6,


                    )
            }

        }
    }
}


