package com.example.digikala1.navigation

sealed class Screen (val rout:String){
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Category : Screen("category_screen")
    object Basket : Screen("basket_screen")
    object Profile : Screen("profile_screen")
    object WebView : Screen("webView_screen")

    fun withArgs(vararg args : Any):String{
        return buildString {
            append(rout)
            args.forEach {
                append("/$it")
            }
        }

    }
}