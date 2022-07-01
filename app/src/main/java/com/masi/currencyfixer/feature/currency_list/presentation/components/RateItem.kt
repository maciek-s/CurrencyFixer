package com.masi.currencyfixer.feature.currency_list.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.masi.currencyfixer.core.presentation.model.RateDisplayable
import com.masi.currencyfixer.core.presentation.theme.LocalSpace
import com.masi.currencyfixer.core.presentation.utils.extensions.formatted

@Composable
fun RateItem(
    rate: RateDisplayable,
    modifier: Modifier = Modifier,
    onClickRate: (RateDisplayable) -> Unit = {},
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
            text = rate.formatted(),
            modifier = Modifier.padding(
                start = LocalSpace.current.large,
                top = LocalSpace.current.small,
                bottom = LocalSpace.current.small
            )
        )
    }
}