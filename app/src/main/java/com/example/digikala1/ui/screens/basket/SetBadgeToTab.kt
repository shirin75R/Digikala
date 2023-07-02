package com.example.digikala1.ui.screens.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.digikala1.ui.theme.digikalaRed
import com.example.digikala1.ui.theme.spacing
import com.example.digikala1.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun SetBadgeToTab(
    selectedTabIndex: Int,
    index: Int,
    cartCounter: Int
) {

    Card(
        modifier = Modifier
            .background(Color.Transparent)
    ) {
        var color = Color.Gray
        if (selectedTabIndex == index) {
            color = MaterialTheme.colors.digikalaRed
        }

        Text(
            text = digitByLocateAndSeparator(cartCounter.toString()),
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            color = Color.White,
            modifier = Modifier
                .background(color = color)
                .padding(horizontal = MaterialTheme.spacing.semiSmall)
        )

    }

}
