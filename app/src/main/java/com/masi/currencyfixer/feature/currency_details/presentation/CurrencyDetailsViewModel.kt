package com.masi.currencyfixer.feature.currency_details.presentation

import androidx.lifecycle.viewModelScope
import com.masi.currencyfixer.core.base.BaseViewModel
import com.masi.currencyfixer.core.domain.model.SymbolWithDate
import com.masi.currencyfixer.feature.currency_details.domain.usecase.GetRate
import com.masi.currencyfixer.feature.currency_details.presentation.model.CurrencyDetailsContract.CurrencyDetailsIntent
import com.masi.currencyfixer.feature.currency_details.presentation.model.CurrencyDetailsContract.CurrencyDetailsState
import com.masi.currencyfixer.feature.currency_list.presentation.model.Rate
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrencyDetailsViewModel @Inject constructor(
    private val getRate: GetRate,
) : BaseViewModel<CurrencyDetailsState, CurrencyDetailsIntent>() {

    override val initialState: CurrencyDetailsState = CurrencyDetailsState()

    override fun onTriggerIntent(intent: CurrencyDetailsIntent) {
        when (intent) {
            is CurrencyDetailsIntent.GetRate -> fetchRate(intent.symbolWithDate)
        }
    }

    private fun fetchRate(symbolWithDate: SymbolWithDate) {
        viewModelScope.launch {
            try {
                val rate = Rate(
                    symbol = symbolWithDate.symbol,
                    value = getRate(symbolWithDate),
                )
                _state.update { it.copy(date = symbolWithDate.date, rate = rate) }
            } catch (e: Exception) {
                // TODO handle error
                e.printStackTrace()
            }
        }
    }

}