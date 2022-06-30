package com.masi.currencyfixer.core.domain.model

import com.masi.currencyfixer.core.data.remote.model.TimeseriesDto
import com.masi.currencyfixer.feature.currency_list.presentation.model.Rate
import com.masi.currencyfixer.feature.currency_list.presentation.model.TimeseriesDisplayable

data class Timeseries(
    val startDate: String,
    val endDate: String,
    val base: String,
    val rates: Map<String, Map<String, Float>>,
)

fun TimeseriesDto.toTimeseries() = Timeseries(
    startDate = startDate,
    endDate = endDate,
    base = base,
    rates = rates,
)

fun Timeseries.toTimeseriesDisplayables(): List<TimeseriesDisplayable> {
    return rates.map { entry ->
        val rates = entry.value.map { Rate(it.key, it.value) }
        TimeseriesDisplayable(
            date = entry.key,
            rates = rates
        )
    }
}