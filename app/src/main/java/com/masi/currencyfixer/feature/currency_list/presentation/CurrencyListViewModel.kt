package com.masi.currencyfixer.feature.currency_list.presentation

import androidx.lifecycle.viewModelScope
import com.masi.currencyfixer.core.base.BaseViewModel
import com.masi.currencyfixer.core.domain.model.toHistoricalRatesDisplayable
import com.masi.currencyfixer.feature.currency_list.domain.usecase.GetHistoricalRates
import com.masi.currencyfixer.feature.currency_list.presentation.model.CurrencyListContract.CurrencyListIntent
import com.masi.currencyfixer.feature.currency_list.presentation.model.CurrencyListContract.CurrencyListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val getHistoricalRates: GetHistoricalRates,
) : BaseViewModel<CurrencyListState, CurrencyListIntent>() {

    override val initialState: CurrencyListState = CurrencyListState()

    private var lastHistoricalRatesDate: Calendar? = null

    init {
        fetchHistoricalRates()
    }

    private fun fetchHistoricalRates(
        date: Calendar = Calendar.getInstance()
    ) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val historicalRates = getHistoricalRates(date).toHistoricalRatesDisplayable()
                _state.update { state ->
                    val current = state.historicalRates.toMutableList()
                    current.add(historicalRates)
                    state.copy(historicalRates = current)
                }
                lastHistoricalRatesDate = date
            } catch (e: Exception) {
                e.printStackTrace()
                _state.update { it.copy(error = e.cause?.toString() ?: "Unknown error") }
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }

    override fun onTriggerIntent(intent: CurrencyListIntent) {
        when (intent) {
            CurrencyListIntent.NextPage -> nextPage()
            CurrencyListIntent.Retry -> retry()
        }
    }

    private fun nextPage() {
        val lastDate = requireNotNull(lastHistoricalRatesDate) {
            "nextPage() was called but lastHistoricalRatesDate is null"
        }
        val dayBefore = (lastDate.clone() as Calendar).apply { add(Calendar.DAY_OF_MONTH, -1) }
        fetchHistoricalRates(date = dayBefore)
    }

    private fun retry() {
        fetchHistoricalRates()
    }
}