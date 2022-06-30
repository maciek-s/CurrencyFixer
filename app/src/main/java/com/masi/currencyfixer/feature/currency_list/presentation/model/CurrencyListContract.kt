package com.masi.currencyfixer.feature.currency_list.presentation.model

import com.masi.currencyfixer.core.presentation.model.Contract

class CurrencyListContract : Contract {

    data class CurrencyListState(
        val symbol: String = ""
    ) : Contract.State

    sealed class CurrencyListIntent : Contract.Intent {
    }
}