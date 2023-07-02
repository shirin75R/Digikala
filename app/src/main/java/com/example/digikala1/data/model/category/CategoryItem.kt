package com.example.digikala1.data.model.category

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.digikala1.R
import com.example.digikala1.ui.screens.category.SuCategoryItem
import com.example.digikala1.ui.theme.LightCyan
import com.example.digikala1.ui.theme.darkText
import com.example.digikala1.ui.theme.spacing

@Composable
fun CategoryItem(
    title: String,
    subList: List<Sub>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = MaterialTheme.spacing.medium,
                end = MaterialTheme.spacing.Small,
                start = MaterialTheme.spacing.Small,
                bottom = MaterialTheme.spacing.Small
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.see_all),
            style = MaterialTheme.typography.caption,
            color = MaterialTheme.colors.LightCyan,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.Small)
        )


    }
    LazyRow(){
        items(subList){list ->
            SuCategoryItem(list)

        }
    }
}