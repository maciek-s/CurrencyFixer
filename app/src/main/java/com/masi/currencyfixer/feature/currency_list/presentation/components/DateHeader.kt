package com.masi.currencyfixer.feature.currency_list.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.masi.currencyfixer.R
import com.masi.currencyfixer.core.presentation.theme.LocalSpace
import com.masi.currencyfixer.core.presentation.theme.LocalTextSize

@Composable
fun DateHeader(
    date: String,
    modifier: Modifier = Modifier,
) {
    Card {
        Text(
            text = stringResource(id = R.string.date_header, date),
            modifier = modifier
                .padding(all = LocalSpace.current.big),
            fontSize = LocalTextSize.current.large,
            fontWeight = FontWeight.Medium
        )
    }
}