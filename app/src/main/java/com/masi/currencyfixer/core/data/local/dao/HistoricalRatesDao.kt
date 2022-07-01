package com.masi.currencyfixer.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.masi.currencyfixer.core.data.local.model.HistoricalRatesEntity

@Dao
interface HistoricalRatesDao {
    @Insert
    fun insert(historicalRatesEntity: HistoricalRatesEntity)

    @Query("SELECT * FROM historicalRates WHERE date = :date LIMIT 1")
    suspend fun getHistoricalRates(
        date: String
    ): HistoricalRatesEntity?
}