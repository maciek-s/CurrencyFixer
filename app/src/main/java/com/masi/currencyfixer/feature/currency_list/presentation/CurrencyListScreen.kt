package com.masi.currencyfixer.feature.currency_list.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.masi.currencyfixer.R
import com.masi.currencyfixer.feature.currency_list.presentation.components.DateHeader
import com.masi.currencyfixer.feature.currency_list.presentation.components.RateItem
import com.masi.currencyfixer.feature.currency_list.presentation.model.CurrencyListContract.CurrencyListIntent
import com.masi.currencyfixer.feature.currency_list.presentation.model.CurrencyListContract.CurrencyListState
import com.masi.currencyfixer.feature.currency_list.presentation.model.RateWithDate

@Composable
fun CurrencyListScreen(
    viewModel: CurrencyListViewModel,
    onClickRate: (RateWithDate) -> Unit = {}
) {
    val state by viewModel.state.collectAsState()

    CurrencyListContent(
        state = state,
        onScrollToBottom = {
            viewModel.onTriggerIntent(CurrencyListIntent.NextPage)
        },
        onClickRetry = {
            viewModel.onTriggerIntent(CurrencyListIntent.Retry)
        },
        onClickRate = onClickRate
    )
}

@Composable
fun CurrencyListContent(
    state: CurrencyListState,
    onScrollToBottom: () -> Unit = {},
    onClickRetry: () -> Unit = {},
    onClickRate: (RateWithDate) -> Unit = {},
) {
    LazyColumn {
        state.historicalRates.forEach { item ->
            item {
                DateHeader(
                    date = item.date,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            items(item.rates) { rate ->
                RateItem(
                    rate = rate,
                    modifier = Modifier.fillMaxWidth(),
                    onClickRate = {
                        val rateWithDate = RateWithDate(
                            rate = it,
                            date = item.date
                        )
                        onClickRate(rateWithDate)
                    }
                )
            }
        }
        item {
            LaunchedEffect(key1 = true) {
                if (state.historicalRates.isNotEmpty()) {
                    onScrollToBottom()
                }
            }
        }
    }
    if (state.isLoading) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator()
        }
    }
    if (!state.error.isNullOrEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = state.error,
                textAlign = TextAlign.Center,
            )
            Button(
                onClick = onClickRetry
            ) {
                Text(text = stringResource(id = R.string.retry))
            }
        }
    }
}