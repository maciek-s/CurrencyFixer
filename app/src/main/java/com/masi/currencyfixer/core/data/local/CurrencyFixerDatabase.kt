package com.masi.currencyfixer.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.masi.currencyfixer.core.data.local.dao.HistoricalRatesDao
import com.masi.currencyfixer.core.data.local.model.HistoricalRatesEntity
import com.masi.currencyfixer.core.data.local.utils.Converters

@Database(
    version = 1,
    entities = [HistoricalRatesEntity::class],
)
@TypeConverters(Converters::class)
abstract class CurrencyFixerDatabase : RoomDatabase() {
    abstract fun historicalRatesDao(): HistoricalRatesDao

    companion object {
        const val DATABASE_NAME = "currencyFixerDatabase"
    }
}