package com.masi.currencyfixer.core.domain.repository

import com.masi.currencyfixer.core.domain.model.HistoricalRates
import java.util.*

interface CurrencyRepository {

    suspend fun getHistoricalRates(
        date: Calendar,
    ): HistoricalRates
}