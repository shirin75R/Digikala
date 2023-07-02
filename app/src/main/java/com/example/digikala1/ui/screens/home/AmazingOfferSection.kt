package com.example.digikala1.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala1.R
import com.example.digikala1.data.model.home.AmazingItem
import com.example.digikala1.data.remote.NetworkResult
import com.example.digikala1.ui.theme.DigikalaLightRed
import com.example.digikala1.viewmodels.HomeViewModel

@Composable
fun AmazingOfferSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var amazingItemList by remember {
        mutableStateOf<List<AmazingItem>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    val amazingItemResult by viewModel.amazingItems.collectAsState()
    when (amazingItemResult) {
        is NetworkResult.Success -> {
            amazingItemList = amazingItemResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "AmazingOfferSection error : ${amazingItemResult.message}")

        }

        is NetworkResult.Loading -> {
            loading = true

        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.DigikalaLightRed)
    ) {
        LazyRow(
            modifier = Modifier
                .background(MaterialTheme.colors.DigikalaLightRed)
        ) {
            item {
                AmazingOfferCard(R.drawable.amazings, R.drawable.box)
            }
            items(amazingItemList) { item ->
                AmazingItem(item = item)
            }


            item {
                AmazingShowMoreItem()
            }
        }
    }

}