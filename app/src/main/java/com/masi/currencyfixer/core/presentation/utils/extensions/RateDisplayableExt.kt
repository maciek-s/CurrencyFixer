package com.masi.currencyfixer.core.presentation.utils.extensions

import com.masi.currencyfixer.core.presentation.model.RateDisplayable

fun RateDisplayable.formatted(): String {
    return "$symbol : ${formatValue()}"
}

fun RateDisplayable.formatValue(): String {
    return String.format("%.4f", value)
}