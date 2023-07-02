package com.example.digikala1

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.digikala1.navigation.BottomNavigationBar
import com.example.digikala1.navigation.SetupNavGraph
import com.example.digikala1.ui.component.AppConfig
import com.example.digikala1.ui.component.ChangeStatusBarColor
import com.example.digikala1.ui.theme.Digikala1Theme
import com.example.digikala1.util.Constants.ENGLISH_LANG
import com.example.digikala1.util.Constants.USER_LANGUAGE
import com.example.digikala1.util.LocaleUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController: NavHostController

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Digikala1Theme {
                navController = rememberNavController()
                ChangeStatusBarColor(navController)
                AppConfig()

                Log.e("3636", USER_LANGUAGE)
                LocaleUtils.setLocate(LocalContext.current, USER_LANGUAGE)

                val direction = if (USER_LANGUAGE == ENGLISH_LANG){
                    androidx.compose.ui.unit.LayoutDirection.Ltr
                }else{
                    androidx.compose.ui.unit.LayoutDirection.Rtl
                }
                CompositionLocalProvider(LocalLayoutDirection provides direction) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController, onItemClick = {

                                navController.navigate(it.rout)
                            })
                        }

                    ) {
                        SetupNavGraph(navController = navController)
                    }
                }

            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Digikala1Theme {
        Greeting("Android")
    }
}