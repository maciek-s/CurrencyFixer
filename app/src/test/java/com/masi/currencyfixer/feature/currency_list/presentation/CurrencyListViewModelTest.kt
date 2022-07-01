package com.masi.currencyfixer.feature.currency_list.presentation

import com.masi.currencyfixer.core.domain.model.HistoricalRates
import com.masi.currencyfixer.feature.currency_list.domain.usecase.GetDayBefore
import com.masi.currencyfixer.feature.currency_list.domain.usecase.GetHistoricalRates
import com.masi.currencyfixer.feature.currency_list.presentation.model.CurrencyListContract.CurrencyListIntent
import com.masi.currencyfixer.utils.MainDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CurrencyListViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @MockK(relaxed = true)
    lateinit var getHistoricalRates: GetHistoricalRates

    @MockK(relaxed = true)
    lateinit var getDayBefore: GetDayBefore

    @Before
    fun setUp() = MockKAnnotations.init(this)

    @Test
    fun `getHistoricalRates called on init`() = runTest {
        val viewModel = CurrencyListViewModel(getHistoricalRates, getDayBefore)

        coVerify(exactly = 1) { getHistoricalRates(any()) }

        assertEquals(1, viewModel.state.value.historicalRates.size)

        assertTrue(viewModel.state.value.historicalRates.isNotEmpty())
        assertFalse(viewModel.state.value.isLoading)
        assertNull(viewModel.state.value.error)
    }

    @Test
    fun `getHistoricalRates called on event retry`() = runTest {
        val viewModel = CurrencyListViewModel(getHistoricalRates, getDayBefore)

        val mockHistoricalRates = HistoricalRates(
            date = "2022-06-06",
            rates = mapOf("PLN" to 4.7f)
        )
        coEvery { getHistoricalRates(any()) } returns mockHistoricalRates

        viewModel.onTriggerIntent(CurrencyListIntent.Retry)

        coVerify(exactly = 2) { getHistoricalRates(any()) }

        assertFalse(viewModel.state.value.isLoading)
        assertNull(viewModel.state.value.error)
    }

    @Test
    fun `getHistoricalRates and  getDayBefore called on event nextPage`() = runTest {
        val viewModel = CurrencyListViewModel(getHistoricalRates, getDayBefore)

        viewModel.onTriggerIntent(CurrencyListIntent.NextPage)
        coVerify(exactly = 2) { getHistoricalRates(any()) }
        coVerify(exactly = 1) { getDayBefore(any()) }

        assertFalse(viewModel.state.value.isLoading)
        assertNull(viewModel.state.value.error)
    }
}