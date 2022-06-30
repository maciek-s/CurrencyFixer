package com.masi.currencyfixer.core.data.remote.model

import com.masi.currencyfixer.core.domain.model.Timeseries
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TimeseriesDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("timeseries")
    val timeseries: Boolean,
    @SerialName("start_date")
    val startDate: String,
    @SerialName("end_date")
    val endDate: String,
    @SerialName("base")
    val base: String,
    @SerialName("rates")
    val rates: Map<String, Map<String, Float>>,
)