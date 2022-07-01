package com.masi.currencyfixer.feature.currency_details.presentation

import com.masi.currencyfixer.core.domain.model.SymbolWithDate
import com.masi.currencyfixer.feature.currency_details.domain.usecase.GetRate
import com.masi.currencyfixer.feature.currency_details.presentation.model.CurrencyDetailsContract.CurrencyDetailsIntent
import com.masi.currencyfixer.utils.MainDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CurrencyDetailsViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @MockK(relaxed = true)
    lateinit var getRate: GetRate

    @Before
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `on init empty date, empty symbol, value is 0`() = runTest {
        val viewModel = CurrencyDetailsViewModel(getRate)

        coVerify(exactly = 0) { getRate(any()) }

        assertTrue(viewModel.state.value.date.isEmpty())
        assertTrue(viewModel.state.value.rate.symbol.isEmpty())
        assertEquals(0f, viewModel.state.value.rate.value)
    }

    @Test
    fun `getRate called on event getRate`() = runTest {
        val viewModel = CurrencyDetailsViewModel(getRate)

        val mockSymbolWithDate = SymbolWithDate("PLN", "2022-06-06")
        val mockRate = 4.7f

        coEvery { getRate(any()) } returns mockRate

        viewModel.onTriggerIntent(CurrencyDetailsIntent.GetRate(mockSymbolWithDate))

        coVerify(exactly = 1) { getRate(mockSymbolWithDate) }

        assertEquals(mockSymbolWithDate.date, viewModel.state.value.date)
        assertEquals(mockSymbolWithDate.symbol, viewModel.state.value.rate.symbol)
        assertEquals(mockRate, viewModel.state.value.rate.value)
    }
}