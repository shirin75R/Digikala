package com.example.digikala1.repository

import com.example.digikala1.data.model.home.AmazingItem
import com.example.digikala1.data.model.home.MainCategory
import com.example.digikala1.data.model.home.Slider
import com.example.digikala1.data.model.home.StoreProduct
import com.example.digikala1.data.model.profile.LoginRequest
import com.example.digikala1.data.model.profile.LoginResponse
import com.example.digikala1.data.remote.BaseApiResponse
import com.example.digikala1.data.remote.HomeApiInterface
import com.example.digikala1.data.remote.NetworkResult
import com.example.digikala1.data.remote.ProfileApiInterface
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val api: ProfileApiInterface) : BaseApiResponse() {


    suspend fun login(loginRequest: LoginRequest): NetworkResult<LoginResponse> =
        safeApiCall {
            api.login(loginRequest)
        }

}