package com.masi.currencyfixer.feature.currency_details.domain.usecase

import com.masi.currencyfixer.core.domain.model.SymbolWithDate
import com.masi.currencyfixer.core.domain.repository.CurrencyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetRate @Inject constructor(
    private val currencyRepository: CurrencyRepository
) {

    suspend operator fun invoke(
        symbolWithDate: SymbolWithDate
    ): Float {
        val historicalRates = currencyRepository.getHistoricalRates(symbolWithDate.date)
        val rate = historicalRates.rates[symbolWithDate.symbol]
        requireNotNull(rate) {
            "rate for ${symbolWithDate.symbol} was called but not found"
        }
        return rate
    }
}