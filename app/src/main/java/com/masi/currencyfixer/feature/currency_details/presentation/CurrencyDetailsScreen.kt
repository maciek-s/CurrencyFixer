package com.masi.currencyfixer.feature.currency_details.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.masi.currencyfixer.R
import com.masi.currencyfixer.core.domain.model.SymbolWithDate
import com.masi.currencyfixer.core.presentation.theme.LocalSpace
import com.masi.currencyfixer.core.presentation.theme.LocalTextSize
import com.masi.currencyfixer.feature.currency_details.presentation.model.CurrencyDetailsContract.CurrencyDetailsIntent
import com.masi.currencyfixer.feature.currency_details.presentation.model.CurrencyDetailsContract.CurrencyDetailsState
import com.masi.currencyfixer.feature.currency_list.presentation.components.formatValue

@Composable
fun CurrencyDetailsScreen(
    viewModel: CurrencyDetailsViewModel,
    symbolWithDate: SymbolWithDate,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.onTriggerIntent(CurrencyDetailsIntent.GetRate(symbolWithDate))
    }

    CurrencyDetailsContent(
        state = state,
    )
}

@Composable
fun CurrencyDetailsContent(
    state: CurrencyDetailsState,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = LocalSpace.current.big),
        verticalArrangement = Arrangement.spacedBy(LocalSpace.current.small)
    ) {
        Text(
            text = stringResource(id = R.string.date_header, state.date),
            fontSize = LocalTextSize.current.big,
        )
        Text(
            text = "${state.rate.symbol} : ${state.rate.formatValue()}",
            fontSize = LocalTextSize.current.big,
        )
    }
}