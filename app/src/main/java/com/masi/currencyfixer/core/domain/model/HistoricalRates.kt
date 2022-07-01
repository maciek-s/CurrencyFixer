package com.masi.currencyfixer.core.domain.model

import com.masi.currencyfixer.core.data.remote.model.HistoricalRatesDto
import com.masi.currencyfixer.feature.currency_list.presentation.model.HistoricalRatesDisplayable
import com.masi.currencyfixer.feature.currency_list.presentation.model.Rate

data class HistoricalRates(
    val date: String,
    val rates: Map<String, Float>,
)

// Mappers

fun HistoricalRatesDto.toHistoricalRates() = HistoricalRates(
    date = date,
    rates = rates
)

fun HistoricalRates.toHistoricalRatesDisplayable() = HistoricalRatesDisplayable(
    date = date,
    rates = rates.map { Rate(it.key, it.value) }
)