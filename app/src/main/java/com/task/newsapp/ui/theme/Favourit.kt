package com.task.newsapp.ui.theme

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Label
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.task.newsapp.database.entity.ArticleDB
import com.task.newsapp.viewmodel.DatabaseViewmodel
import kotlinx.coroutines.launch

@Composable
fun FavouritScreen( dbViewModel: DatabaseViewmodel = hiltViewModel()) {
    val favouritArtical by remember { dbViewModel.FavouritArtical }.collectAsState()
    val context = LocalContext.current
LazyColumn (
    contentPadding = PaddingValues(horizontal = 10.dp),
    verticalArrangement  = Arrangement.spacedBy(8.dp),
){

//    items(favouritArtical){artical->
//        FavouritItem(artical.urlToImage , artical.title , artical.author)
//    }

    favouritArtical?.let {
        try {
            items(it){ artical->
                FavouritItem(artical.urlToImage , artical.title , artical.author)
            }

        }catch (e:Exception){
            Toast.makeText(context , "database error" , Toast.LENGTH_LONG).show()
        }
    }
}
}


@Composable
fun FavouritItem(
    imageUrl:String?=null,
    title:String?=null,
    auther :String ?= null,
) {
    Surface(
        shape = MaterialTheme.shapes.small,

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = rememberAsyncImagePainter(
                    ImageRequest.Builder(LocalContext.current).data(data = imageUrl)
                        .apply(block = fun ImageRequest.Builder.() {
                            transformations()
                        }).build()

                ),
                contentDescription = null,
                modifier = Modifier.width(100.dp).height(150.dp),
                contentScale = ContentScale.Crop
            )
            Column {
                androidx.compose.material.Text(
                    text = "$auther",
                    modifier = Modifier.padding(horizontal = 16.dp).width(150.dp),
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )
                androidx.compose.material.Text(
                    text = "$title",
                    modifier = Modifier.padding(horizontal = 16.dp).width(150.dp),
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold
                )


            }


        }
    }
}