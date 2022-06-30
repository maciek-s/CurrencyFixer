package com.masi.currencyfixer.feature.currency_list.presentation.model

data class TimeseriesDisplayable(
    val date: String,
    val rates: List<Rate> = emptyList(),
)

data class Rate(
    val symbol: String,
    val value: Float,
)