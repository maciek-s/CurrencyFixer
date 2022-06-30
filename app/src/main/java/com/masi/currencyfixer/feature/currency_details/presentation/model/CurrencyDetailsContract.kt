package com.masi.currencyfixer.feature.currency_details.presentation.model

import com.masi.currencyfixer.core.presentation.model.Contract

class CurrencyDetailsContract : Contract {

    data class CurrencyDetailsState(
        val currencies: List<String> = emptyList()
    ) : Contract.State

    sealed class CurrencyDetailsIntent : Contract.Intent {
    }
}