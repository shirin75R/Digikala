package com.example.digikala1.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.digikala1.R
import com.example.digikala1.ui.component.IconWhitRotate
import com.example.digikala1.ui.theme.DigikalaLightRed
import com.example.digikala1.ui.theme.darkText
import com.example.digikala1.ui.theme.roundedShape
import com.example.digikala1.ui.theme.spacing

@Composable
fun AmazingShowMoreItem() {
    Card(
        modifier = Modifier
            .size(180.dp, 375.dp)
            .padding(
                end = MaterialTheme.spacing.medium,
                start = MaterialTheme.spacing.semiSmall,
                top = MaterialTheme.spacing.semiLarge
            ),
        shape = MaterialTheme.roundedShape.small,
        contentColor = Color.White
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconWhitRotate(painterResource(
                id = R.drawable.show_more),
                MaterialTheme.colors.DigikalaLightRed)


            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = stringResource(id = R.string.see_all),
                style = MaterialTheme.typography.caption,
                color = MaterialTheme.colors.darkText,
                fontWeight = FontWeight.SemiBold
            )

        }

    }
}