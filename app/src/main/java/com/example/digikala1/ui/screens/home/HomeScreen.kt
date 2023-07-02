package com.example.digikala1.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.digikala1.util.Constants
import com.example.digikala1.util.LocaleUtils
import com.example.digikala1.viewmodels.HomeViewModel
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController) {
    Home(navController = navController)
}

@Composable
fun Home(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    LocaleUtils.setLocate(LocalContext.current, Constants.USER_LANGUAGE)

    LaunchedEffect(key1 = true) {
        refreshDataFromServer(viewModel)
    }
    SwipeRefreshSection(viewModel,navController)
}

@Composable
private fun SwipeRefreshSection(viewModel: HomeViewModel, navController: NavHostController) {
    val refreshScope = rememberCoroutineScope()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = false)
    SwipeRefresh(state = swipeRefreshState,
        onRefresh = {
            refreshScope.launch {
                refreshDataFromServer(viewModel = viewModel)
                Log.e("3636", "swipeRefresh")
            }
        }) {

        LazyColumn(modifier = Modifier.fillMaxSize().padding(bottom = 60.dp)) {
            item { SearchBarSection() }
            item { TopSliderSection() }
            item { ShowcaseSection(navController) }
            item { AmazingOfferSection() }
            item {ProposalCardSection()}
            item { SuperMarketOfferSection() }
            item { CategoryListSection() }
            item { CenterBannerSection(1) }
            item { BestSellerOfferSection() }
            item { CenterBannerSection(2) }
            item {MostFavoriteProductSection() }
            item { CenterBannerSection(3) }
            item {MostVisitOfferSection() }
            item { CenterBannerSection(4) }

            item { CenterBannerSection(5) }
            item {MostDiscountedSection() }

        }
    }
}


private suspend fun refreshDataFromServer(viewModel: HomeViewModel) {
    viewModel.getAllDataFromServer()
}