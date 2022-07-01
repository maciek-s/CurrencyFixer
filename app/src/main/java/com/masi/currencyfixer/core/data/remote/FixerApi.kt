package com.masi.currencyfixer.core.data.remote

import com.masi.currencyfixer.core.data.remote.model.HistoricalRatesDto
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FixerApi @Inject constructor(
    private val httpClient: HttpClient
) {

    suspend fun getHistoricalRates(
        date: String,
        base: String = "EUR"
    ): HistoricalRatesDto {
        return httpClient.get("$BASE_URL/$date") {
            addApiHeader()
            url {
                parameters.append("base", base)
            }
        }.body()
    }

    private fun HttpRequestBuilder.addApiHeader() {
        headers {
            append(API_KEY_HEADER_NAME, API_KEY)
        }
    }

    companion object {
        private const val API_KEY_HEADER_NAME = "apikey"
        private const val API_KEY = "8m1UZZfEKOD2TFv9Gj4op8wfCz5Prd42"
        private const val BASE_URL = "https://api.apilayer.com/fixer"
    }
}