package com.masi.currencyfixer.core.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HistoricalRatesDto(
    @SerialName("base")
    val base: String,
    @SerialName("date")
    val date: String,
    @SerialName("historical")
    val historical: Boolean,
    @SerialName("rates")
    val rates: Map<String, Float>,
    @SerialName("success")
    val success: Boolean,
    @SerialName("timestamp")
    val timestamp: Long
)