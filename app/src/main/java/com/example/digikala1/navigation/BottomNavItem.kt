package com.example.digikala1.navigation

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavItem(
    val name :String,
    val rout : String,
    val selectedIcon : Painter,
    val deSelectedIcon : Painter,
)
