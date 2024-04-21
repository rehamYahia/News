package com.task.newsapp.ui.theme

import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.task.newsapp.R
import com.task.newsapp.viewmodel.AppleViewModel
import com.task.newsapp.viewmodel.TechCrunchViewModel


@Composable
fun TechCrunchArticals(viewModel: TechCrunchViewModel = hiltViewModel()) {
    val techCrunch by remember { viewModel.TechCrunch }.collectAsState()
    val context = LocalContext.current
    LazyHorizontalGrid(rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 10.dp),
        modifier = Modifier.height(130.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    )
    {
        techCrunch?.let {
            try {
                items(it.articles) { artical ->
                    TechCrunchItem(artical.urlToImage , artical.author)
                }

            } catch (e: Exception) {
                Toast.makeText(context, e.message.toString(), Toast.LENGTH_LONG).show()
            }
        }
    }
}


@Composable
fun TechCrunchItem(
    imageUrl:String?=null,
    auther :String ?= null,
    modifier: Modifier = Modifier)
{
    Surface(
        shape = MaterialTheme.shapes.small,

        ) {
        Row(modifier = Modifier
            .width(320.dp),
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
                modifier = Modifier.width(100.dp).height(100.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = "$auther",
                modifier = Modifier.padding(horizontal = 16.dp).width(150.dp),
                style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Bold
            )
            Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_favourit),
                contentDescription = "Android Icon",
//                tint = Color.Red,
                modifier = Modifier.size(30.dp))
        }
    }

}