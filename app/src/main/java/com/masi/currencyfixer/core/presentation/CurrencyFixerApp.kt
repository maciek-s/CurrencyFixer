package com.masi.currencyfixer.core.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.masi.currencyfixer.core.presentation.navigation.NavGraph
import com.masi.currencyfixer.core.presentation.navigation.model.Screen
import com.masi.currencyfixer.core.presentation.theme.CurrencyFixerTheme

@Composable
fun CurrencyFixerApp(
    navController: NavHostController = rememberNavController()
) {
    CurrencyFixerTheme {
        NavGraph(
            navController = navController,
            startDestination = Screen.CurrencyList.route
        )
    }
}