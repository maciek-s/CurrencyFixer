package com.masi.currencyfixer.core.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "historicalRates"
)
data class HistoricalRatesEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: String,
    val rates: Map<String, Float>
)