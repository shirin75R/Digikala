package com.example.digikala1.ui.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
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
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.digikala1.R
import com.example.digikala1.data.model.home.StoreProduct
import com.example.digikala1.data.remote.NetworkResult
import com.example.digikala1.ui.theme.darkText
import com.example.digikala1.ui.theme.spacing
import com.example.digikala1.viewmodels.HomeViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MostDiscountedSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var mostDiscountList by remember {
        mutableStateOf<List<StoreProduct>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    val mostDiscountListResult by viewModel.mostDiscountedItems.collectAsState()
    when (mostDiscountListResult) {
        is NetworkResult.Success -> {
            mostDiscountList = mostDiscountListResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "MostDiscountedSection error : ${mostDiscountListResult.message}")

        }

        is NetworkResult.Loading -> {
            loading = true
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.Small),
            text = stringResource(id = R.string.most_discounted_products),
            textAlign = TextAlign.Right,
            color = MaterialTheme.colors.darkText,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.SemiBold
        )
        FlowRow(
            maxItemsInEachRow = 2,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.Start
        ) {
            for (item in mostDiscountList){
                MostDiscountedCard(item)
            }

        }
    }
}