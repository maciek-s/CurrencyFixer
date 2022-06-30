package com.masi.currencyfixer.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.masi.currencyfixer.core.presentation.navigation.model.Screen
import com.masi.currencyfixer.feature.currency_details.presentation.CurrencyDetailsScreen
import com.masi.currencyfixer.feature.currency_details.presentation.CurrencyDetailsViewModel
import com.masi.currencyfixer.feature.currency_list.presentation.CurrencyListScreen
import com.masi.currencyfixer.feature.currency_list.presentation.CurrencyListViewModel

@Composable
fun NavGraph(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.CurrencyList.route,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        currencyList(
            navController = navController,
        )
        currencyDetails()
    }
}

private fun NavGraphBuilder.currencyList(
    navController: NavHostController,
) {
    composable(route = Screen.CurrencyList.route) {
        val viewModel = hiltViewModel<CurrencyListViewModel>()

        CurrencyListScreen(
            viewModel = viewModel,
        )
    }
}

private fun NavGraphBuilder.currencyDetails() {
    composable(
        route = Screen.CurrencyDetails.route + "/{${Screen.CURRENCY_SYMBOL_KEY}}",
        arguments = listOf(
            navArgument(Screen.CURRENCY_SYMBOL_KEY) { type = NavType.StringType }
        )
    ) { backStackEntry ->
        val arguments = requireNotNull(backStackEntry.arguments)
        val viewModel = hiltViewModel<CurrencyDetailsViewModel>()

        CurrencyDetailsScreen(
            viewModel = viewModel,
        )
    }
}