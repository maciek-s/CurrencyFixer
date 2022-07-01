package com.masi.currencyfixer.core.domain.repository

import com.masi.currencyfixer.core.domain.model.HistoricalRates
import java.util.*

interface CurrencyRepository {

    suspend fun getHistoricalRates(
        calendar: Calendar,
    ): HistoricalRates

    suspend fun getHistoricalRates(
        date: String,
    ): HistoricalRates
}