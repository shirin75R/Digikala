package com.example.digikala1.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

import com.example.digikala1.R
import com.example.digikala1.ui.screens.basket.IconWithBadge
import com.example.digikala1.ui.theme.bottomBar
import com.example.digikala1.ui.theme.extraBoldNumber
import com.example.digikala1.ui.theme.font_bold
import com.example.digikala1.ui.theme.selectedBottomBar
import com.example.digikala1.ui.theme.unSelectedBottomBar
import com.example.digikala1.util.Constants
import com.example.digikala1.util.LocaleUtils
import com.example.digikala1.viewmodels.BasketViewModel

@Composable
fun BottomNavigationBar(
    navController: NavController,
    onItemClick: (BottomNavItem) -> Unit,
    viewModel: BasketViewModel = hiltViewModel()
) {
    LocaleUtils.setLocate(LocalContext.current, Constants.USER_LANGUAGE)
    val items = listOf(
        BottomNavItem(
            name = stringResource(id = R.string.home),
            rout = Screen.Home.rout,
            selectedIcon = painterResource(id = R.drawable.home_fill),
            deSelectedIcon = painterResource(id = R.drawable.home_outline),
        ),
        BottomNavItem(
            name = stringResource(id = R.string.category),
            rout = Screen.Category.rout,
            selectedIcon = painterResource(id = R.drawable.category_fill),
            deSelectedIcon = painterResource(id = R.drawable.category_outline),
        ),
        BottomNavItem(
            name = stringResource(id = R.string.basket),
            rout = Screen.Basket.rout,
            selectedIcon = painterResource(id = R.drawable.cart_fill),
            deSelectedIcon = painterResource(id = R.drawable.cart_outline),
        ),
        BottomNavItem(
            name = stringResource(id = R.string.my_digikala),
            rout = Screen.Profile.rout,
            selectedIcon = painterResource(id = R.drawable.user_fill),
            deSelectedIcon = painterResource(id = R.drawable.user_outline),
        ),
    )
    //In order to say on which pages the bottomBar should be displayed
    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in items.map { it.rout }
    if (showBottomBar) {
        BottomNavigation(
            modifier = Modifier.height(60.dp),
            backgroundColor = MaterialTheme.colors.bottomBar,
            elevation = 5.dp
        ) {
            val cartCounter by viewModel.currentCartItemsCount.collectAsState(0)
            items.forEachIndexed { index, item ->
                val selected = item.rout == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    selectedContentColor = MaterialTheme.colors.selectedBottomBar,
                    unselectedContentColor = MaterialTheme.colors.unSelectedBottomBar,
                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            if (selected) {
                                if (index == 2 && cartCounter > 0) {
                                    IconWithBadge(
                                        cartCounter = cartCounter, icon = item.selectedIcon
                                    )
                                } else {
                                    Icon(
                                        modifier = Modifier.height(24.dp),
                                        painter = item.selectedIcon,
                                        contentDescription = item.name
                                    )
                                }

                            } else {
                                if (index == 2 && cartCounter > 0) {
                                    IconWithBadge(
                                        cartCounter = cartCounter, icon = item.deSelectedIcon
                                    )
                                } else {
                                    Icon(
                                        modifier = Modifier.height(24.dp),
                                        painter = item.deSelectedIcon,
                                        contentDescription = item.name
                                    )
                                }
                            }
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.subtitle1,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 5.dp)
                            )


                        }
                    }
                )
            }
        }
    }
}