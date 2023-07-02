package com.example.digikala1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.digikala1.ui.screens.basket.BasketScreen
import com.example.digikala1.ui.screens.category.CategoryScreen
import com.example.digikala1.ui.screens.home.HomeScreen
import com.example.digikala1.ui.screens.home.WebPageScreen
import com.example.digikala1.ui.screens.profile.ProfileScreen
import com.example.digikala1.ui.screens.splash.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.rout
    ) {
        composable(route = Screen.Splash.rout) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Home.rout) {
            HomeScreen(navController = navController)
        }
        composable(route = Screen.Category.rout) {
            CategoryScreen(navController = navController)
        }
        composable(route = Screen.Basket.rout) {
            BasketScreen(navController = navController)
        }
        composable(route = Screen.Profile.rout) {
            ProfileScreen(navController = navController)
        }
        composable(
            route = Screen.WebView.rout + "?url={url}",
            arguments = listOf(navArgument("url") {
                type = NavType.StringType
                defaultValue = ""
                nullable = true
            })
        ){
            val url = it.arguments?.getString("url")
            url?.let {
                WebPageScreen(navController = navController, url = url)
            }
        }
    }
}