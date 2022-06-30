package com.masi.currencyfixer.feature.currency_list.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.masi.currencyfixer.feature.currency_list.presentation.model.CurrencyListContract.CurrencyListState

@Composable
fun CurrencyListScreen(
    viewModel: CurrencyListViewModel,
) {
    val state by viewModel.state.collectAsState()

    CurrencyListContent(
        state = state,
    )
}

@Composable
fun CurrencyListContent(
    state: CurrencyListState,
) {
    LazyColumn {
        items(state.timeseries) { item ->
            Text(text = "Date: ${item.date}")
            item.rates.forEach { rate ->
                Text(text = "${rate.symbol} : ${rate.value}")
            }
        }
    }
}