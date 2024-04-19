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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.task.newsapp.viewmodel.BitcoinViewModel
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsApp()
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
                auther: String?=null,
                title: String?=null,
                description: String?=null,
                urlToImage: String?=null,
                publishedAt: String?=null,
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



//-------------------------------


@Composable
fun HomeScreen() {
    BitcoinArticals()
}

@Composable
fun FavouritScreen() {

}

sealed class Screen(val route: String, val title: String) {
    object Home : Screen("home", "Home")
    object Profile : Screen("profile", "Profile")

    // Add more screens as needed
}

@Composable
fun BottomNavigationBar(
    navController: NavController,
    items: List<Screen>
) {

    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { screen ->
            BottomNavigationItem(
                icon = { /* Icon for the screen */ },
                label = { Text(text = screen.title) },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}


@Composable
fun NewsApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen() }
        composable(Screen.Profile.route) { FavouritScreen() }

        // Add more composable destinations as needed
    }

    BottomNavigationBar(navController = navController, items = listOf(Screen.Home, Screen.Profile))
}




