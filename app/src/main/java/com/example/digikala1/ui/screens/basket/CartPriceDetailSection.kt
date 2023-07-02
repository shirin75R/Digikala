package com.example.digikala1.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Colors
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.digikala1.R
import com.example.digikala1.ui.theme.darkText
import com.example.digikala1.ui.theme.digikalaRed
import com.example.digikala1.ui.theme.spacing
import com.example.digikala1.util.DigitHelper
import com.example.digikala1.util.DigitHelper.digitByLocateAndSeparator

@Composable
fun CartPriceDetailSection() {
    Column(
        modifier = Modifier.padding(MaterialTheme.spacing.medium)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.basket_summary),
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.darkText
            )

            Text(
                text = "${DigitHelper.digitByLocateAndSeparator("۳")}${stringResource(id = R.string.goods)} ",
                style = MaterialTheme.typography.caption,
                color = Color.Gray
            )

        }

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.semiLarge))
        PriceRow("dgfg", 233, 5)
        PriceRow("dgfg", 233, 5)
        PriceRow("dgfg", 233, 5)

        Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.dot_bullet),
                color = Color.Gray,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(MaterialTheme.spacing.extraSmall)
            )
            Text(
                text = stringResource(id = R.string.shipping_cost_alert),
                color = Color.Gray,
                style = MaterialTheme.typography.caption,
                modifier = Modifier.weight(1f)
            )
        }
        Divider(
            Modifier
                .padding(
                    vertical = MaterialTheme.spacing.medium,
                    horizontal = MaterialTheme.spacing.Small
                )
                .alpha(0.6f),
            color = Color.LightGray
        )
        DigiClubScore(7)
    }
}

@Composable
private fun DigiClubScore(

    score: Int,
) {
    Spacer(modifier = Modifier.height(MaterialTheme.spacing.medium))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
        ) {
            Image(
                painter = painterResource(id = R.drawable.digi_score),
                contentDescription = "",
                modifier = Modifier
                    .size(22.dp)
                    .padding(MaterialTheme.spacing.extraSmall)
            )
            Text(
                text = stringResource(id = R.string.digiclub_score),
                color = Color.Gray,
                style = MaterialTheme.typography.caption,
                fontWeight = FontWeight.Medium
            )

        }
        Text(
            text = "${digitByLocateAndSeparator(score.toString())}${stringResource(id = R.string.score)}",
            color = MaterialTheme.colors.darkText,
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.End,
            fontWeight = FontWeight.Medium
        )


    }

    Text(
        text = stringResource(id = R.string.shipping_cost_alert),
        color = Color.Gray,
        style = MaterialTheme.typography.caption,
        modifier = Modifier.fillMaxWidth()
    )
}


@Composable
private fun PriceRow(
    title: String,
    price: Long,
    discount: Int = 0,
) {
    var color = MaterialTheme.colors.darkText
    if (discount > 0) {
        color = MaterialTheme.colors.digikalaRed
    }


    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.caption,
            color = Color.Gray,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start
        )
        Row {
            Text(
                text = DigitHelper.digitByLocateAndSeparator(price.toString()),
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
                color = color,
            )
            Icon(
                painter = painterResource(id = R.drawable.toman),
                contentDescription = "",
                tint = color,
                modifier = Modifier
                    .size(24.dp)
                    .padding(
                        MaterialTheme.spacing.extraSmall,
                    )
            )

        }

    }

}