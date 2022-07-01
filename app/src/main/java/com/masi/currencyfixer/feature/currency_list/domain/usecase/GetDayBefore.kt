package com.masi.currencyfixer.feature.currency_list.domain.usecase

import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GetDayBefore @Inject constructor() {

    operator fun invoke(
        calendar: Calendar
    ): Calendar {
        return (calendar.clone() as Calendar).apply { add(Calendar.DAY_OF_MONTH, -1) }
    }
}