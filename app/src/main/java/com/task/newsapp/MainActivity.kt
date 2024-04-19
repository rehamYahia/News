package com.task.newsapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.task.newsapp.viewmodel.BitcoinViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BitcoinArticals()
        }
    }
}



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
                auther: String,
                title: String,
                description: String,
                urlToImage: String?=null,
                publishedAt: String,
) {

       Row (modifier = Modifier.padding(10.dp)){
           Image(modifier = Modifier.size(120.dp),
               painter = rememberAsyncImagePainter(
                   ImageRequest.Builder(LocalContext.current).data(data = urlToImage).apply(block = fun ImageRequest.Builder.() {
                       transformations(CircleCropTransformation())
                   }).build()
               ),contentDescription = "image")

           Column(modifier = Modifier.padding(7.dp)

           ) {
               Text(
                   text = "Auther: $auther"
               )
               Text(
                   text = "Title: $title"
               )
               Text(
                   text = "Description:$description "
               )

               Text(
                   text = "PublishedAt: $publishedAt"
               )
           }
       }
    }

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        BitcoinItem("fbfcvfnv","gbdb "," dch","c bc b","bbhbchd")
}