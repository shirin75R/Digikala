package com.example.digikala1.repository


import com.example.digikala1.data.model.category.SubCategory
import com.example.digikala1.data.remote.BaseApiResponse
import com.example.digikala1.data.remote.CategoryApiInterface
import com.example.digikala1.data.remote.NetworkResult
import javax.inject.Inject

class CategoryRepository @Inject constructor(private val api: CategoryApiInterface) : BaseApiResponse() {

    suspend fun getSubCategories(): NetworkResult<SubCategory> =
        safeApiCall {
            api.getSubCategories()
        }

}