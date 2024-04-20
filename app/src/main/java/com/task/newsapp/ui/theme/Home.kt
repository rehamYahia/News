package com.task.newsapp.ui.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



@Composable
fun HomeScreen(){
    Column {
        Spacer(modifier = Modifier.padding(vertical = 10.dp))
        HomeSection("Bitcoin Articals" ){
            BitcoinArticals()
        }

    }

}
@Composable
fun HomeSection(title:String , content: @Composable ()-> Unit){
    Text(
        text = title.uppercase(),
        style = MaterialTheme.typography.bodyLarge,
        modifier = Modifier
            .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
            .padding(horizontal = 16.dp)
    )
    content()


}