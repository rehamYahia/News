package com.task.newsapp.ui.theme

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.shape.CircleShape

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.task.newsapp.viewmodel.AppleViewModel
import com.task.newsapp.viewmodel.BitcoinViewModel


@Composable
fun AppleArticals(viewModel: AppleViewModel = hiltViewModel()) {
    val apple by remember { viewModel.Apple }.collectAsState()
    val context = LocalContext.current
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    )
    {
        apple?.let {
            try {
                items(it.articles) { artical ->
                    AppleArticalItem(modifier = Modifier, artical.urlToImage, artical.author)
                }

            } catch (e: Exception) {
                Toast.makeText(context, e.message.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}


@Composable
fun AppleArticalItem(
    modifier: Modifier = Modifier,
    imageurl: String?=null,
    auther: String?=null
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = imageurl)
                    .apply(block = fun ImageRequest.Builder.() {
                        transformations(CircleCropTransformation())
                    }).build()
            ),
            contentDescription = null,
            modifier = Modifier.width(100.dp).height(100.dp),
            contentScale = ContentScale.Crop,

        )
        Text(
            text = "$auther",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp),
            fontSize = 12.sp,
            color = Color.Gray,
        )

    }

}