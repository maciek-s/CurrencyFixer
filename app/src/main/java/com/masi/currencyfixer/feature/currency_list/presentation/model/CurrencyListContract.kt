package com.masi.currencyfixer.feature.currency_list.presentation.model

import com.masi.currencyfixer.core.presentation.model.Contract

class CurrencyListContract : Contract {

    data class CurrencyListState(
        val isLoading: Boolean = false,
        val timeseries: List<TimeseriesDisplayable> = emptyList()
    ) : Contract.State

    sealed class CurrencyListIntent : Contract.Intent {
    }
}