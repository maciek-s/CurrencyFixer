package com.masi.currencyfixer.feature.currency_list.presentation.model

data class Rate(
    val symbol: String = "",
    val value: Float = 0f,
)