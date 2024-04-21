package com.task.newsapp.ui.theme

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.task.newsapp.R


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
//               NewsApp()
                App()
            }

        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) { HomeScreen() }
        composable(Screen.Favourit.route) { FavouritScreen() }

    }


}

//@Composable
//fun BottomNavigationBar(navController: NavController) {
//    val items: List<Screen> = listOf(Screen.Home, Screen.Favourit)
//
//    BottomNavigation(
//        modifier = Modifier.fillMaxWidth(),
//        backgroundColor = colorResource(id = R.color.black),
//        contentColor = Color.White,
//        elevation = 8.dp
//    ) {
//        val navBackStackEntry by navController.currentBackStackEntryAsState()
//        val currentRoute = navBackStackEntry?.destination?.route
//        items.forEach { screen ->
//            BottomNavigationItem(
//                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
//                label = { Text(text = screen.title) },
//                selected = currentRoute == screen.route,
//                selectedContentColor = Color.White,
//                unselectedContentColor = Color.White.copy(0.4f),
//                alwaysShowLabel = true,
//                onClick = {
//                    navController.navigate(screen.route) {
//                        popUpTo(navController.graph.startDestinationId) {
//                            saveState = true
//                        }
//                        launchSingleTop = true
//                        restoreState = true
//                    }
//                }
//            )
//        }
//    }
//}







