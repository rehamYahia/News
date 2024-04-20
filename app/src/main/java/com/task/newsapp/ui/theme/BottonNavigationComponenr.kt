package com.task.newsapp.ui.theme



import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.task.newsapp.R

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Favourit : Screen("favourit", "Favourit", Icons.Default.Favorite)
}


@Composable
fun mainScreen(){
    val navController = rememberNavController()

    Scaffold (
        bottomBar = {}
    ){
        bottomNavGraph(navController = navController)
    }
}

@Composable
fun bottomBar(navController: NavHostController){
    val screens = listOf(
        Screen.Home,
        Screen.Favourit
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    screens.forEach{screen ->  
        
    }

}

@Composable
fun addItem(){

}

//@Composable
//fun rowScope.addItem(
//)
//{
//
//}

@Composable
fun bottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route= Screen.Home.route) { HomeScreen() }
        composable(route= Screen.Favourit.route) { FavouritScreen() }

        // Add more composable destinations as needed
    }
}


@Composable
fun BottomNavigationBar(
    items: List<Screen>,
    navController: NavController
) {

    BottomNavigation(
        modifier = Modifier.fillMaxWidth(),
        backgroundColor = colorResource(id = R.color.black),
        contentColor = Color.White,
        elevation = 8.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { screen ->
            BottomNavigationItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                label = { Text(text = screen.title) },
                selected = currentRoute == screen.route,
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
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
                })
        }
    }
}



