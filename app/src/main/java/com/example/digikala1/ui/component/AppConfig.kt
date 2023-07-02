package com.example.digikala1.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala1.util.Constants.USER_LANGUAGE
import com.example.digikala1.viewmodels.DataStoreViewModel

@Composable
fun AppConfig (
    dataStore: DataStoreViewModel = hiltViewModel()
){
        getDataStoreVariables(dataStore)
}
private  fun getDataStoreVariables(dataStore : DataStoreViewModel){
    USER_LANGUAGE = dataStore.getUserLanguage()
    dataStore.saveUserLanguage(USER_LANGUAGE)
}