package com.example.digikala1.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala1.data.remote.NetworkResult
import com.example.digikala1.util.Constants.USER_ID
import com.example.digikala1.util.Constants.USER_LANGUAGE
import com.example.digikala1.util.Constants.USER_PASSWORD
import com.example.digikala1.util.Constants.USER_PHONE
import com.example.digikala1.util.Constants.USER_TOKEN
import com.example.digikala1.viewmodels.DataStoreViewModel
import com.example.digikala1.viewmodels.ProfileViewModel
import kotlinx.coroutines.Dispatchers

@Composable
fun AppConfig(
    profileViewModel: ProfileViewModel = hiltViewModel(),
    dataStore: DataStoreViewModel = hiltViewModel()
) {
    getDataStoreVariables(dataStore)
    profileViewModel.refreshToken(USER_PHONE, USER_PASSWORD)
    val loginResponse by profileViewModel.loginResponse.collectAsState()


    LaunchedEffect(Dispatchers.Main){
        when (loginResponse) {
            is NetworkResult.Success -> {
                loginResponse.data?.let { user ->
                    if (user.token.isNotEmpty()) {
                        dataStore.saveUserToken(user.token)
                        dataStore.saveUserID(user.id)
                        dataStore.saveUserPhone(user.phone)
                        dataStore.saveUserPassword(USER_PASSWORD)

                        getDataStoreVariables(dataStore)
                    }
                }
            }

            else -> {}
        }
    }

}

private fun getDataStoreVariables(dataStore: DataStoreViewModel) {
    USER_LANGUAGE = dataStore.getUserLanguage()
    dataStore.saveUserLanguage(USER_LANGUAGE)

    USER_PHONE = dataStore.getUserPhone().toString()
    USER_PASSWORD = dataStore.getUserPassword().toString()
    USER_TOKEN = dataStore.getUserToken().toString()
    USER_ID = dataStore.getUserID().toString()
}