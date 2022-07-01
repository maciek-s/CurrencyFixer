package com.masi.currencyfixer.feature.currency_list.presentation.model

import com.masi.currencyfixer.core.presentation.model.Contract

class CurrencyListContract : Contract {

    data class CurrencyListState(
        val isLoading: Boolean = false,
        val historicalRates: List<HistoricalRatesDisplayable> = emptyList(),
        val error: String? = null,
    ) : Contract.State

    sealed class CurrencyListIntent : Contract.Intent {
        object NextPage : CurrencyListIntent()
        object Retry : CurrencyListIntent()
    }
}