package com.masi.currencyfixer.feature.currency_list.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.masi.currencyfixer.core.presentation.theme.LocalSpace
import com.masi.currencyfixer.feature.currency_list.presentation.model.Rate

@Composable
fun RateItem(
    rate: Rate,
    modifier: Modifier = Modifier,
    onClickRate: (Rate) -> Unit = {},
) {
    Card(
        modifier = modifier
            .padding(
                horizontal = LocalSpace.current.small,
                vertical = LocalSpace.current.verySmall,
            )
            .clickable {
                onClickRate(rate)
            }
    ) {
        Text(
            text = "${rate.symbol} : ${rate.formatValue()}",
            modifier = Modifier.padding(
                start = LocalSpace.current.large,
                top = LocalSpace.current.small,
                bottom = LocalSpace.current.small
            )
        )
    }
}

fun Rate.formatValue(): String {
    return String.format("%.4f", value)
}