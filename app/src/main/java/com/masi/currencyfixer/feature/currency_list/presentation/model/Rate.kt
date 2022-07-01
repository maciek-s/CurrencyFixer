package com.masi.currencyfixer.feature.currency_list.presentation.model

data class Rate(
    val symbol: String,
    val value: Float,
)

data class RateWithDate(
    val rate: Rate,
    val date: String,
)