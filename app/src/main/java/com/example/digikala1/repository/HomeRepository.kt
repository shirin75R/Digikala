package com.example.digikala1.repository

import com.example.digikala1.data.model.home.AmazingItem
import com.example.digikala1.data.model.home.MainCategory
import com.example.digikala1.data.model.home.Slider
import com.example.digikala1.data.model.home.StoreProduct
import com.example.digikala1.data.remote.BaseApiResponse
import com.example.digikala1.data.remote.HomeApiInterface
import com.example.digikala1.data.remote.NetworkResult
import javax.inject.Inject

class HomeRepository @Inject constructor(private val api: HomeApiInterface) : BaseApiResponse() {


    suspend fun getSlider(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getSlider()
        }
    suspend fun getAmazingItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingItems()
        }
    suspend fun getAmazingSuperMarketItems(): NetworkResult<List<AmazingItem>> =
        safeApiCall {
            api.getAmazingSuperMarketItems()
        }
    suspend fun getProposalBanners(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getProposalBanners()
        }
    suspend fun getCategories(): NetworkResult<List<MainCategory>> =
        safeApiCall {
            api.getCategories()
        }
    suspend fun getCenterBanners(): NetworkResult<List<Slider>> =
        safeApiCall {
            api.getCenterBanners()
        }
    suspend fun getBestSellerItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getBestSellerItems()
        }
    suspend fun getMostVisitedItems(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostVisitedItems()
        }
    suspend fun getMostFavoriteProducts(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostFavoriteProducts()
        }
    suspend fun getMostDiscountedProducts(): NetworkResult<List<StoreProduct>> =
        safeApiCall {
            api.getMostDiscountedProducts()
        }

}