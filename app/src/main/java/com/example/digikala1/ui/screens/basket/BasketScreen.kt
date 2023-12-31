package com.example.digikala1.ui.screens.basket


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala1.R
import com.example.digikala1.ui.theme.darkText
import com.example.digikala1.ui.theme.digikalaRed
import com.example.digikala1.ui.theme.spacing
import com.example.digikala1.viewmodels.BasketViewModel
import kotlinx.coroutines.flow.collectLatest


@Composable
fun BasketScreen(navController: NavHostController) {
    Basket(navController = navController)
}

@Composable
fun Basket(
    navController: NavHostController,
    viewModel: BasketViewModel = hiltViewModel()
) {
    val currentCartItemsCount by  viewModel.currentCartItemsCount.collectAsState(0)
    val nextCartItemsCount by  viewModel.nextCartItemsCount.collectAsState(0)


    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val tabTitles = listOf(
        stringResource(id = R.string.cart),
        stringResource(id = R.string.next_cart_list)
    )
    Column {
        TabRow(
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.medium),
            selectedTabIndex = selectedTabIndex,
            contentColor = MaterialTheme.colors.digikalaRed,
            backgroundColor = Color.White,
            indicator = { line ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(line[selectedTabIndex])
                        .height(3.dp)
                        .background(Color.Red)
                )
            }
        ) {
            tabTitles.forEachIndexed { index, title ->
                Tab(
                    selected =(selectedTabIndex==index),
                    onClick = {
                        selectedTabIndex=index
                    },
                    selectedContentColor = MaterialTheme.colors.digikalaRed,
                    unselectedContentColor = Color.Gray,
                    text = {
                        Row {
                            Text(text = title,
                                style = MaterialTheme.typography.caption,
                                fontWeight = FontWeight.SemiBold

                            )
                            val cartCounter = if(index==0){
                                currentCartItemsCount
                            }else{
                                nextCartItemsCount
                            }
                            if (cartCounter>0){
                                Spacer(modifier =Modifier. width(10.dp))
                                SetBadgeToTab(selectedTabIndex,index,cartCounter)
                            }
                        }
                    }
                )
            }
        }
        when(selectedTabIndex){
            0 ->ShoppingCart()
            1->NextShoppingList()
        }
    }

}
