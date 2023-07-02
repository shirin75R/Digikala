package com.example.digikala1.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.digikala1.R
import com.example.digikala1.navigation.Screen
import com.example.digikala1.ui.component.RoundedIconBox
import com.example.digikala1.ui.theme.LocalSpacing
import com.example.digikala1.ui.theme.amber
import com.example.digikala1.ui.theme.grayCategory
import com.example.digikala1.util.Constants.AUCTION_URL
import com.example.digikala1.util.Constants.DIGIJET_URL
import com.example.digikala1.util.Constants.DIGIPAY_URL
import com.example.digikala1.util.Constants.DIGIPLUS_URL
import com.example.digikala1.util.Constants.GIFT_CARD_URL
import com.example.digikala1.util.Constants.MORE_URL
import com.example.digikala1.util.Constants.PINDO_URL
import com.example.digikala1.util.Constants.SHOPPING_URL

@Composable
fun ShowcaseSection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = LocalSpacing.current.semiMedium,
                vertical = LocalSpacing.current.biggerSmall
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            RoundedIconBox(
                image = painterResource(id = R.drawable.digijet),
                title = stringResource(id = R.string.digikala_jet),
                onClick = onBoxClick(
                    navController = navController,
                    url = DIGIJET_URL
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.auction),
                title = stringResource(id = R.string.digi_style),
                onClick = onBoxClick(
                    navController = navController,
                    url =AUCTION_URL
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digipay),
                title = stringResource(id = R.string.digi_pay),
                onClick = onBoxClick(
                    navController = navController,
                    url = DIGIPAY_URL
                )
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.pindo),
                title = stringResource(id = R.string.pindo),
                onClick = onBoxClick(
                    navController = navController,
                    url = PINDO_URL
                ),
                bgColor = MaterialTheme.colors.amber
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = LocalSpacing.current.semiSmall),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            RoundedIconBox(
                image = painterResource(id = R.drawable.shopping),
                title = stringResource(id = R.string.digi_shopping),
                onClick = onBoxClick(
                    navController = navController,
                    url = SHOPPING_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.giftcard),
                title = stringResource(id = R.string.gift_card),
                onClick = onBoxClick(
                    navController = navController,
                    url = GIFT_CARD_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.digiplus),
                title = stringResource(id = R.string.digi_plus),
                onClick = onBoxClick(
                    navController = navController,
                    url =DIGIPLUS_URL
                ),
            )
            RoundedIconBox(
                image = painterResource(id = R.drawable.more),
                title = stringResource(id = R.string.more),
                onClick = onBoxClick(
                    navController = navController,
                    url =MORE_URL
                ),
                bgColor = MaterialTheme.colors.grayCategory
            )
        }
    }
}

@Composable
fun onBoxClick(navController: NavController, url: String): () -> Unit =
    { navController.navigate(route = Screen.WebView.rout + "?url=${url}") }

