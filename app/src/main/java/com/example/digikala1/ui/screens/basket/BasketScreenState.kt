package com.example.digikala1.ui.screens.basket

import java.lang.Exception

sealed class BasketScreenState<out T> {
    object Loading : BasketScreenState<Nothing>()
    data class Success<T>(val data: T) : BasketScreenState<T>()
    data class Error<T>(val error: Exception) : BasketScreenState<Nothing>()

}
