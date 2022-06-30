package com.masi.currencyfixer.feature.currency_details.presentation

import com.masi.currencyfixer.core.base.BaseViewModel
import com.masi.currencyfixer.feature.currency_details.presentation.model.CurrencyDetailsContract
import com.masi.currencyfixer.feature.currency_details.presentation.model.CurrencyDetailsContract.CurrencyDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CurrencyDetailsViewModel @Inject constructor(
) : BaseViewModel<CurrencyDetailsState, CurrencyDetailsContract.CurrencyDetailsIntent>() {

    override val initialState: CurrencyDetailsState = CurrencyDetailsState()

    override fun onTriggerIntent(intent: CurrencyDetailsContract.CurrencyDetailsIntent) {
    }


}