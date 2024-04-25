package com.task.newsapp.ui.theme



import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.task.newsapp.R



@Composable
fun HomeScreen(modifier: Modifier = Modifier.background(purple800)) {

    Column( modifier.padding(20.dp)) {
        component()
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
fun component(modifier: Modifier = Modifier) {
    Spacer(modifier.padding(10.dp))

    Image(
        painter = painterResource(R.drawable.ic_image),
        contentDescription = null,
        modifier = Modifier
            .width(70.dp)
            .height(70.dp),
        contentScale = ContentScale.Crop
    )

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
            color = Color.White
        )
        content()
    }
}