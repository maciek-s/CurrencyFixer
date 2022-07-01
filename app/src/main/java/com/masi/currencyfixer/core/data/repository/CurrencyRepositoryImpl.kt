package com.masi.currencyfixer.core.data.repository

import com.masi.currencyfixer.core.data.local.dao.HistoricalRatesDao
import com.masi.currencyfixer.core.data.remote.FixerApi
import com.masi.currencyfixer.core.domain.model.HistoricalRates
import com.masi.currencyfixer.core.domain.model.toHistoricalRates
import com.masi.currencyfixer.core.domain.model.toHistoricalRatesEntity
import com.masi.currencyfixer.core.domain.repository.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val fixerApi: FixerApi,
    private val historicalRatesDao: HistoricalRatesDao
) : CurrencyRepository {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.ROOT)

    override suspend fun getHistoricalRates(calendar: Calendar): HistoricalRates {
        return withContext(Dispatchers.IO) {
            val date = dateFormat.format(calendar.time)
            var local = historicalRatesDao.getHistoricalRates(date)
            if (local == null) {
                val remote = fixerApi.getHistoricalRates(
                    date = date,
                )
                historicalRatesDao.insert(remote.toHistoricalRatesEntity())
                local = historicalRatesDao.getHistoricalRates(date)
            }
            requireNotNull(local) {
                "getHistoricalRates() was called but local is null"
            }

            local.toHistoricalRates()
        }
    }
}