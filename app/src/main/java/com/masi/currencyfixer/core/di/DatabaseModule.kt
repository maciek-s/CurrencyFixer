package com.masi.currencyfixer.core.di

import android.content.Context
import androidx.room.Room
import com.masi.currencyfixer.core.data.local.CurrencyFixerDatabase
import com.masi.currencyfixer.core.data.local.CurrencyFixerDatabase.Companion.DATABASE_NAME
import com.masi.currencyfixer.core.data.local.dao.HistoricalRatesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): CurrencyFixerDatabase {
        return Room.databaseBuilder(
            context,
            CurrencyFixerDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun provideHistoricalRatesDao(
        database: CurrencyFixerDatabase
    ): HistoricalRatesDao = database.historicalRatesDao()

}