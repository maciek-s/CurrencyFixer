package com.masi.currencyfixer.core.base

import androidx.lifecycle.ViewModel
import com.masi.currencyfixer.core.presentation.model.Contract
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel<S : Contract.State, I : Contract.Intent> : ViewModel() {

    protected abstract val initialState: S

    protected val _state: MutableStateFlow<S> by lazy { MutableStateFlow(initialState) }

    val state: StateFlow<S> by lazy { _state.asStateFlow() }

    abstract fun onTriggerIntent(intent: I)
}