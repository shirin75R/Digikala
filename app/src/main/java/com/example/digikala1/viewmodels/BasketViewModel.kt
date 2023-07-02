package com.example.digikala1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikala1.data.model.basket.CartItem
import com.example.digikala1.data.model.basket.CartStatus
import com.example.digikala1.data.model.home.AmazingItem
import com.example.digikala1.data.model.home.MainCategory
import com.example.digikala1.data.model.home.Slider
import com.example.digikala1.data.model.home.StoreProduct
import com.example.digikala1.data.remote.NetworkResult
import com.example.digikala1.repository.BasketRepository
import com.example.digikala1.repository.HomeRepository
import com.example.digikala1.ui.screens.basket.BasketScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BasketViewModel @Inject constructor(private val repository: BasketRepository) : ViewModel() {

    val suggestedList = MutableStateFlow<NetworkResult<List<StoreProduct>>>(NetworkResult.Loading())


    private val _currentCartItems: MutableStateFlow<BasketScreenState<List<CartItem>>> =
        MutableStateFlow(BasketScreenState.Loading)
    val currentCartItems: StateFlow<BasketScreenState<List<CartItem>>> = _currentCartItems


    private val _nextCartItems: MutableStateFlow<BasketScreenState<List<CartItem>>> =
        MutableStateFlow(BasketScreenState.Loading)
    val nextCartItems: StateFlow<BasketScreenState<List<CartItem>>> = _nextCartItems

    init {
        viewModelScope.launch(Dispatchers.IO) {
            launch {

                repository.currentCartItems.collectLatest { cartItems ->
                    _currentCartItems.emit(BasketScreenState.Success(cartItems))
                }
            }

            launch {
                repository.nextCartItems.collectLatest { nextCartItems ->
                    _nextCartItems.emit(BasketScreenState.Success(nextCartItems))
                }
            }
        }
    }

    fun getSuggestedItems() {
        viewModelScope.launch {
            suggestedList.emit(repository.getSuggestedItems())
        }
    }

    fun insertCartItem(item: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertCartItem(item)
        }
    }

    fun removeCartItem(item: CartItem) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.removeFromCart(item)
        }
    }

    fun changeCartItemCount(id: String, newCount: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCartItemCount(id, newCount)
        }
    }

    fun changeCartItemStatus(id: String, newStatus: CartStatus) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.changeCartItemStatus(id, newStatus)
        }
    }
}