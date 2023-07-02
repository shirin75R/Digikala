package com.example.digikala1.ui.screens.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.digikala1.data.model.home.Slider
import com.example.digikala1.data.remote.NetworkResult
import com.example.digikala1.ui.theme.roundedShape
import com.example.digikala1.ui.theme.spacing
import com.example.digikala1.viewmodels.HomeViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProposalCardSection(
    viewModel: HomeViewModel = hiltViewModel()
) {
    var bannersList by remember {
        mutableStateOf<List<Slider>>(emptyList())
    }
    var loading by remember {
        mutableStateOf(false)
    }
    val bannersResult by viewModel.banners.collectAsState()
    when (bannersResult) {
        is NetworkResult.Success -> {
            bannersList = bannersResult.data ?: emptyList()
            loading = false
        }

        is NetworkResult.Error -> {
            loading = false
            Log.e("3636", "bannersSection error : ${bannersResult.message}")

        }

        is NetworkResult.Loading -> {
            loading = true

        }
    }
    FlowRow(
        maxItemsInEachRow = 2,
        modifier = Modifier
            .padding(MaterialTheme.spacing.Small)
            .fillMaxWidth()
            .height(
                (290.dp)
            )
    ) {
        for (item in bannersList) {
            ProposalCardItem(item)
        }
    }

}

@Composable
fun ProposalCardItem(imgLink: Slider) {
    Card(
        shape = MaterialTheme.roundedShape.semiMedium,
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(140.dp)
            .padding(
                horizontal = MaterialTheme.spacing.Small, vertical = MaterialTheme.spacing.Small
            )
    ) {
        Image(
            painter = rememberAsyncImagePainter(imgLink.image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )

    }
}