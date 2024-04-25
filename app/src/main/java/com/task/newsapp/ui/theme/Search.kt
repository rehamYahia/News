package com.task.newsapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.task.newsapp.R
import com.task.newsapp.constant.Constants
import com.task.newsapp.database.entity.ArticleDB
import com.task.newsapp.model.AllResponse
import com.task.newsapp.model.Article
import com.task.newsapp.viewmodel.DatabaseViewmodel
import com.task.newsapp.viewmodel.SearchViewModel
import kotlinx.coroutines.launch






@Composable
fun SearchScreen(modifier :Modifier= Modifier.fillMaxSize().background(purple800)) {

    Column(modifier.padding(10.dp)) {
        SearchField()
        Design()
    }
}


@SuppressLint("CoroutineCreationDuringComposition", "StateFlowValueCalledInComposition")
@Composable
fun SearchField( viewModel: SearchViewModel = hiltViewModel()) {
    val searchValue = remember { mutableStateOf("") }
    val lifecycleOwner = LocalLifecycleOwner.current

    TextField(
        value = searchValue.value,
        onValueChange = { text ->
            searchValue.value = text
        },
        singleLine = true,
        placeholder = { Text(text = stringResource(id = R.string.placeholder_search) , color = Color.DarkGray , fontSize = 21.sp) },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(10.dp),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor =Color.White,
            focusedIndicatorColor = Color.Gray,
            unfocusedIndicatorColor = Color.Gray
        ),
        textStyle = TextStyle(color = Color.DarkGray , fontSize = 20.sp),
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null , tint = Color.DarkGray)  },
        shape = androidx.compose.material3.MaterialTheme.shapes.medium,

        )
    if (searchValue.value.isNotEmpty() && (searchValue.value == "bitcoin" || searchValue.value == "apple")) {
        lifecycleOwner.lifecycleScope.launch {
            viewModel.getDataSearch(searchValue.value, Constants.API_KEY)
        }
        val response = viewModel.SearchArtical.value
        if (response != null) {
            Design( response)
        }
    }
}

@Composable
fun Design( response: AllResponse?=null ) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (response != null) {
            items(response.articles) { article ->
                SearchDesign(article.urlToImage, article.title,article.author)
            }
        }
    }
}




@Composable
fun SearchDesign(
    imageUrl:String?=null,
    title:String?=null,
    auther :String ?= null,
    )
{
    Surface(
        shape = MaterialTheme.shapes.large,

        ) {
        Row(modifier = Modifier
            .fillMaxWidth().background(purple800),
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
            Column() {
                Text(
                    text = "$auther",
                    modifier = Modifier.padding(horizontal = 16.dp).width(150.dp),
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color.White

                )

                Text(
                    text = "$title",
                    modifier = Modifier.padding(horizontal = 16.dp).width(150.dp),
                    style = androidx.compose.material3.MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Bold,
                    fontSize = 17.sp,
                    color = Color.White
                )
            }

        }
    }

}


