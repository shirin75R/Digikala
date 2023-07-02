package com.example.digikala1.data.remote

import com.example.digikala1.data.model.ResponseResult
import com.example.digikala1.data.model.home.AmazingItem
import com.example.digikala1.data.model.home.MainCategory
import com.example.digikala1.data.model.home.Slider
import com.example.digikala1.data.model.home.StoreProduct
import retrofit2.Response
import retrofit2.http.GET

interface ProfileApiInterface {

    @GET("v1/getSlider")
    suspend fun getSlider():Response<ResponseResult<List<Slider>>>

}