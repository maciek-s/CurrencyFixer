package com.masi.currencyfixer.feature.currency_details.presentation.model

import com.masi.currencyfixer.core.domain.model.SymbolWithDate
import com.masi.currencyfixer.core.presentation.model.Contract
import com.masi.currencyfixer.feature.currency_list.presentation.model.Rate

class CurrencyDetailsContract : Contract {

    data class CurrencyDetailsState(
        val date: String = "",
        val rate: Rate = Rate(),
    ) : Contract.State

    sealed class CurrencyDetailsIntent : Contract.Intent {
        data class GetRate(val symbolWithDate: SymbolWithDate) : CurrencyDetailsIntent()
    }
}