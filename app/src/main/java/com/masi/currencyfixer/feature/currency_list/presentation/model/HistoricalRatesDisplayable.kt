package com.masi.currencyfixer.feature.currency_list.presentation.model

import com.masi.currencyfixer.core.presentation.model.RateDisplayable

data class HistoricalRatesDisplayable(
    val date: String,
    val rates: List<RateDisplayable> = emptyList(),
)