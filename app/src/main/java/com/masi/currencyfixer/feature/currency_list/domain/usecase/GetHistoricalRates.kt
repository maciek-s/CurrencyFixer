package com.masi.currencyfixer.feature.currency_list.domain.usecase

import com.masi.currencyfixer.core.domain.model.HistoricalRates
import com.masi.currencyfixer.core.domain.repository.CurrencyRepository
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetHistoricalRates @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {

    suspend operator fun invoke(
        calendar: Calendar
    ): HistoricalRates {
        return currencyRepository.getHistoricalRates(calendar)
    }
}