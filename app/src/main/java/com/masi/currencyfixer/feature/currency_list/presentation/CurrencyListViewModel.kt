package com.masi.currencyfixer.feature.currency_list.presentation

import com.masi.currencyfixer.core.base.BaseViewModel
import com.masi.currencyfixer.feature.currency_list.presentation.model.CurrencyListContract.CurrencyListIntent
import com.masi.currencyfixer.feature.currency_list.presentation.model.CurrencyListContract.CurrencyListState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyListViewModel @Inject constructor(
) : BaseViewModel<CurrencyListState, CurrencyListIntent>() {

    override val initialState: CurrencyListState = CurrencyListState()

    override fun onTriggerIntent(intent: CurrencyListIntent) {

    }
}