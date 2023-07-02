package com.example.digikala1.repository


import com.example.digikala1.data.db.CartDao
import com.example.digikala1.data.model.basket.CartItem
import com.example.digikala1.data.model.basket.CartStatus
import com.example.digikala1.data.model.home.StoreProduct
import com.example.digikala1.data.remote.BaseApiResponse
import com.example.digikala1.data.remote.BasketApiInterface
import com.example.digikala1.data.remote.NetworkResult
import javax.inject.Inject

class BasketRepository @Inject constructor(
    private val api: BasketApiInterface,
    private val dao: CartDao
) :
    BaseApiResponse() {


    val currentCartItems = dao.getAllItems(CartStatus.CURRENT_CART)
    val nextCartItems = dao.getAllItems(CartStatus.NEXT_CART)

    val currentCartItemsCount = dao.getCartItemCount(CartStatus.CURRENT_CART)
    val nextCartItemsCount = dao.getCartItemCount(CartStatus.NEXT_CART)

    suspend fun getSuggestedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getSuggestedItems()
        }

    suspend fun insertCartItem(cart : CartItem){
        dao.insertCartItem(cart)
    }

    suspend fun removeFromCart(cart:CartItem){
        dao.removeFromCart(cart)
    }

    suspend fun changeCartItemStatus( id :String,newStatus: CartStatus){
        dao.changeStatusCart(id, newStatus)
    }

    suspend fun changeCartItemCount( id :String,newCount: Int){
        dao.changeCountCartItem(id, newCount)
    }

}
