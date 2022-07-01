package com.masi.currencyfixer.core.data.local.utils

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {

    @TypeConverter
    fun fromMap(map: Map<String, Float>) : String {
        return Json.encodeToString(map)
    }

    @TypeConverter
    fun toMap(json: String): Map<String, Float> {
        return Json.decodeFromString(json)
    }
}