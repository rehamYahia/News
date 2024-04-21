package com.task.newsapp.ui.theme

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.task.newsapp.R

@Composable
fun search(modifier: Modifier = Modifier)
{
    TextField(value = "",
        onValueChange = {},
        placeholder = { Text(text = stringResource(id = R.string.placeholder_search)) },

        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        colors = TextFieldDefaults.textFieldColors(backgroundColor= MaterialTheme.colors.surface),
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = null) },
        shape = androidx.compose.material3.MaterialTheme.shapes.medium
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun searchPreview()
{
    NewsAppTheme {
        search()
    }

}