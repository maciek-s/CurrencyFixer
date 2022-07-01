package com.masi.currencyfixer.core.domain.model

import com.masi.currencyfixer.core.data.local.model.HistoricalRatesEntity
import com.masi.currencyfixer.core.data.remote.model.HistoricalRatesDto
import com.masi.currencyfixer.core.presentation.model.RateDisplayable
import com.masi.currencyfixer.feature.currency_list.presentation.model.HistoricalRatesDisplayable

data class HistoricalRates(
    val date: String,
    val rates: Map<String, Float>,
)

// Mappers

fun HistoricalRatesDto.toHistoricalRatesEntity() = HistoricalRatesEntity(
    date = date,
    rates = rates
)

fun HistoricalRatesEntity.toHistoricalRates() = HistoricalRates(
    date = date,
    rates = rates,
)

fun HistoricalRates.toHistoricalRatesDisplayable() = HistoricalRatesDisplayable(
    date = date,
    rates = rates.map { RateDisplayable(it.key, it.value) }
)