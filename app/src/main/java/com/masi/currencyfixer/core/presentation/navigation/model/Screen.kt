package com.masi.currencyfixer.core.presentation.navigation.model

sealed class Screen(
    val route: String
) {
    object CurrencyList : Screen("currencyList")
    object CurrencyDetails : Screen("currencyDetails")

    fun withArgs(vararg args: Any): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

    companion object {
        const val CURRENCY_SYMBOL_KEY = "currencySymbolKey"
    }
}