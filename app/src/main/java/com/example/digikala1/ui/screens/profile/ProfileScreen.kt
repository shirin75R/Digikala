package com.example.digikala1.ui.screens.profile

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.digikala1.MainActivity
import com.example.digikala1.R
import com.example.digikala1.ui.theme.darkText
import com.example.digikala1.ui.theme.searchBarBg
import com.example.digikala1.ui.theme.selectedBottomBar
import com.example.digikala1.ui.theme.semiDarkText
import com.example.digikala1.ui.theme.spacing
import com.example.digikala1.util.Constants.ENGLISH_LANG
import com.example.digikala1.util.Constants.PERSIAN_LANG
import com.example.digikala1.viewmodels.DataStoreViewModel
import com.example.digikala1.viewmodels.ProfileViewModel

@Composable
fun ProfileScreen(
    navController: NavHostController,
    dataStore: DataStoreViewModel = hiltViewModel(),
    profileViewModel: ProfileViewModel = hiltViewModel()
) {

    when(profileViewModel.screenState){
        ProfileScreenState.LOGIN_STATE ->{
            LoginScreen()
        }
        ProfileScreenState.PROFILE_STATE ->{
            Profile()
        }
        ProfileScreenState.REGISTER_STATE ->{
            RegisterScreen()
        }
    }
}

@Composable
fun Profile (){
    Text(text = "Profile")
}

/*
Column(
modifier = Modifier
.fillMaxSize()
.background(Color.Yellow),
horizontalAlignment = Alignment.CenterHorizontally,
verticalArrangement = Arrangement.Center
) {
    val activity = LocalContext.current as Activity
    Text(text = "ProfileScreen")
    Button(
        onClick = {
            dataStore.saveUserLanguage(PERSIAN_LANG)
            activity.apply {
                activity.finish()
                activity.startActivity(Intent(activity, MainActivity::class.java))
            }
        }) {
        Text(text = "fa")
    }
    Button(
        onClick = {
            dataStore.saveUserLanguage(ENGLISH_LANG)
            activity.apply {
                activity.finish()
                activity.startActivity(Intent(activity, MainActivity::class.java))
            }
        }) {
        Text(text = "en")
    }
}*/