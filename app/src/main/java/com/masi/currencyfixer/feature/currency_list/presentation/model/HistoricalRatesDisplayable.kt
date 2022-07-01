package com.masi.currencyfixer.feature.currency_list.presentation.model

data class HistoricalRatesDisplayable(
    val date: String,
    val rates: List<Rate> = emptyList(),
)