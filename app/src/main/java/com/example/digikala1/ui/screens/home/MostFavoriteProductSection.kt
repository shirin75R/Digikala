package com.example.digikala1.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala1.R
import com.example.digikala1.data.model.home.StoreProduct
import com.example.digikala1.data.remote.NetworkResult
import com.example.digikala1.ui.theme.DarkCyan
import com.example.digikala1.ui.theme.darkText
import com.example.digikala1.ui.theme.spacing
import com.example.digikala1.viewmodels.HomeViewModel

@Composable
fun MostFavoriteProductSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var mostFavoriteList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    val mostFavoriteResult by viewModel.mostFavoriteItems.collectAsState()
    when (mostFavoriteResult) {
        is NetworkResult.Success -> {
            mostFavoriteList = mostFavoriteResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", " MostFavoriteProductSection error : ${mostFavoriteResult.message}")

        }

        is NetworkResult.Loading -> {
            loading = true

        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(MaterialTheme.spacing.Small)
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = MaterialTheme.spacing.extraSmall)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.favorite_product),
                textAlign = TextAlign.Start,
                color = MaterialTheme.colors.darkText,
                style = MaterialTheme.typography.subtitle1,
                fontWeight = FontWeight.SemiBold,
            )
            Text(
                text = stringResource(id = R.string.see_all),
                textAlign = TextAlign.End,
                color = MaterialTheme.colors.DarkCyan,
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.SemiBold,
            )

        }

        LazyRow {
            items(mostFavoriteList) { item ->
                MostFavoriteProductsOffer(item)
            }
            item {
                MostFavoriteProductsShowMore()
            }
        }
    }
}