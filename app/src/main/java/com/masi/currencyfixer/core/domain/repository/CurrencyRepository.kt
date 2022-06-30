package com.masi.currencyfixer.core.domain.repository

import com.masi.currencyfixer.core.domain.model.Timeseries
import java.util.*

interface CurrencyRepository {

    suspend fun getTimeseries(
        startDate: Calendar,
        endDate: Calendar,
    ): Timeseries
}