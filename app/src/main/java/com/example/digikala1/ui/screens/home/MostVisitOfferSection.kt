package com.example.digikala1.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala1.R
import com.example.digikala1.data.model.home.MainCategory
import com.example.digikala1.data.model.home.StoreProduct
import com.example.digikala1.data.remote.NetworkResult
import com.example.digikala1.ui.theme.darkText
import com.example.digikala1.ui.theme.spacing
import com.example.digikala1.util.DigitHelper
import com.example.digikala1.viewmodels.HomeViewModel

@Composable
fun MostVisitOfferSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var mostVisitList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    val mostVisitResult by viewModel.mostVisitedItems.collectAsState()
    when (mostVisitResult) {
        is NetworkResult.Success -> {
            mostVisitList = mostVisitResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "MostVisitOfferSection error : ${mostVisitResult.message}")

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
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = stringResource(id = R.string.most_visited_products),
            textAlign = TextAlign.Start,
            color = MaterialTheme.colors.darkText,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.SemiBold,
        )
        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            modifier = Modifier
                .padding(top = MaterialTheme.spacing.medium)
                .height(250.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ){
            itemsIndexed(mostVisitList){index, item ->
                ProductHorizontalCard(
                    name = item.name,
                    id = DigitHelper.digitByLocate((index+1).toString()),
                    imageUrl = item.image)
            }

        }

    }

}