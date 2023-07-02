package com.example.digikala1.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.digikala1.data.DataStore.DataStoreRepository
import com.example.digikala1.util.Constants.PERSIAN_LANG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val repository :DataStoreRepository
):ViewModel() {

    companion object{
        const val USER_LANGUAGE_KEY="USER_LANGUAGE_KEY"
    }
    fun saveUserLanguage(value:String){
        viewModelScope.launch{
            repository.putString(USER_LANGUAGE_KEY,value)
        }
    }
     fun getUserLanguage():String = runBlocking {

         repository.getString(USER_LANGUAGE_KEY) ?: PERSIAN_LANG
     }
}