package com.masi.currencyfixer.feature.currency_list.presentation

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
    Text(text = "Currency list")
//    ScalingLazyColumn(
//        modifier = Modifier.fillMaxSize(),
//        state = listState
//    ) {
//        items(state.pages) { page ->
//            PageChip(
//                page = page,
//                onClick = onClickPage
//            )
//        }
//    }
}