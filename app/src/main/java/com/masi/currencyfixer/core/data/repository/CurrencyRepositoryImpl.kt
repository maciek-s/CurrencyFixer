package com.masi.currencyfixer.core.data.repository

import com.masi.currencyfixer.core.data.remote.FixerApi
import com.masi.currencyfixer.core.domain.model.HistoricalRates
import com.masi.currencyfixer.core.domain.model.toHistoricalRates
import com.masi.currencyfixer.core.domain.repository.CurrencyRepository
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val fixerApi: FixerApi
) : CurrencyRepository {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ROOT)


    override suspend fun getHistoricalRates(date: Calendar): HistoricalRates {
        return fixerApi.getHistoricalRates(
            date = dateFormat.format(date.time),
        ).toHistoricalRates()
    }
}