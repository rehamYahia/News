package com.task.newsapp.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.lifecycleScope
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.task.newsapp.R
import com.task.newsapp.constant.Constants
import com.task.newsapp.model.AllResponse
import com.task.newsapp.viewmodel.SearchViewModel
import kotlinx.coroutines.launch


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
        placeholder = { Text(text = stringResource(id = R.string.placeholder_search)) },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(10.dp),
        colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colors.surface),
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        shape = androidx.compose.material3.MaterialTheme.shapes.medium
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
fun SearchScreen(modifier :Modifier= Modifier) {

    Column {
        Spacer(modifier.padding(vertical = 10.dp))
        SearchField()
        Spacer(modifier.padding(vertical = 10.dp))
        Design()
    }
}

@Composable
fun Design( response: AllResponse?=null ) {

    LazyColumn() {
        if (response != null) {
            items(response.articles) { article ->
                SearchDesign(article.urlToImage, article.author)
            }
        }
    }
}


@Composable
fun SearchDesign(
    imageUrl: String? = null,
    auther: String? = null,
) {

    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier

        ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(purple800)
                .padding(10.dp),
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

        }
    }

}








