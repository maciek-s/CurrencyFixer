package com.masi.currencyfixer.feature.currency_list.presentation

import androidx.lifecycle.viewModelScope
import com.masi.currencyfixer.core.base.BaseViewModel
import com.masi.currencyfixer.core.domain.model.toTimeseriesDisplayables
import com.masi.currencyfixer.core.domain.repository.CurrencyRepository
import com.masi.currencyfixer.feature.currency_list.presentation.model.CurrencyListContract.CurrencyListIntent
import com.masi.currencyfixer.feature.currency_list.presentation.model.CurrencyListContract.CurrencyListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
    private val currencyRepository: CurrencyRepository,
) : BaseViewModel<CurrencyListState, CurrencyListIntent>() {

    override val initialState: CurrencyListState = CurrencyListState()

    init {
        viewModelScope.launch {
            val today = Calendar.getInstance()
            val yesterday = (today.clone() as Calendar).apply { add(Calendar.DAY_OF_MONTH, -1) }
            val timeseries = currencyRepository.getTimeseries(
                yesterday,
                today
            )
            _state.update {
                it.copy(
                    isLoading = false,
                    timeseries = timeseries.toTimeseriesDisplayables()
                )
            }
        }
    }

    override fun onTriggerIntent(intent: CurrencyListIntent) {

    }
}