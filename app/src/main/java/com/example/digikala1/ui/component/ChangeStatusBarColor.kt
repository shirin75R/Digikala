package com.example.digikala1.ui.component

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.digikala1.navigation.Screen
import com.example.digikala1.ui.theme.Purple80
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ChangeStatusBarColor(navController: NavHostController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val systemUiController = rememberSystemUiController()

    val statusBarColor = if (MaterialTheme.colors.isLight) {
        Color.White
    }else{
        Color.Black
    }
    when (navBackStackEntry?.destination?.route) {
        Screen.Splash.rout -> {
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Purple80
                )
            }
        }

        else -> {
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = statusBarColor
                )
            }
        }
    }
}