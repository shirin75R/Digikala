package com.example.digikala1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikala1.data.model.category.SubCategory
import com.example.digikala1.data.model.home.AmazingItem
import com.example.digikala1.data.model.home.MainCategory
import com.example.digikala1.data.model.home.Slider
import com.example.digikala1.data.model.home.StoreProduct
import com.example.digikala1.data.remote.NetworkResult
import com.example.digikala1.repository.CategoryRepository
import com.example.digikala1.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository) : ViewModel() {

    val subCategory = MutableStateFlow<NetworkResult<SubCategory>>(NetworkResult.Loading())


    suspend fun getAllDataFromServer() {
        viewModelScope.launch {
            //fire and forget
            launch {
                subCategory.emit(repository.getSubCategories())
            }
        }
    }
}