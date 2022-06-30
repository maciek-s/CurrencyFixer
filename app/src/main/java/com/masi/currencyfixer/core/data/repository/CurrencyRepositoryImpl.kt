package com.masi.currencyfixer.core.data.repository

import com.masi.currencyfixer.core.data.remote.FixerApi
import com.masi.currencyfixer.core.domain.model.Timeseries
import com.masi.currencyfixer.core.domain.model.toTimeseries
import com.masi.currencyfixer.core.domain.repository.CurrencyRepository
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val fixerApi: FixerApi
) : CurrencyRepository {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ROOT)

    override suspend fun getTimeseries(
        startDate: Calendar,
        endDate: Calendar
    ): Timeseries {
        return fixerApi.getTimeSeries(
            startDate = dateFormat.format(startDate.time),
            endDate = dateFormat.format(endDate.time)
        ).toTimeseries()
    }
}