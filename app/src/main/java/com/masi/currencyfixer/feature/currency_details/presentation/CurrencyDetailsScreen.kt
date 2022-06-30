package com.masi.currencyfixer.feature.currency_details.presentation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.masi.currencyfixer.feature.currency_details.presentation.model.CurrencyDetailsContract.CurrencyDetailsState

@Composable
fun CurrencyDetailsScreen(
    viewModel: CurrencyDetailsViewModel,
) {
    val state by viewModel.state.collectAsState()

    CurrencyDetailsContent(
        state = state,
    )
}

@Composable
fun CurrencyDetailsContent(
    state: CurrencyDetailsState,
) {
    Text(text = "Currency detail")
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