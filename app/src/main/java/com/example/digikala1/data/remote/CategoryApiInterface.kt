package com.example.digikala1.data.remote

import com.example.digikala1.data.model.ResponseResult
import com.example.digikala1.data.model.category.SubCategory
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApiInterface {
    @GET("v1/getSubCategories")
    suspend fun getSubCategories():Response<ResponseResult<SubCategory>>
}