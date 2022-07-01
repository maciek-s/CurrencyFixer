package com.masi.currencyfixer.core.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Immutable
data class TextSize(
    val tiny: TextUnit = 8.sp,
    val verySmall: TextUnit = 10.sp,
    val small: TextUnit = 12.sp,
    val medium: TextUnit = 14.sp,
    val big: TextUnit = 16.sp,
    val large: TextUnit = 20.sp,
    val veryLarge: TextUnit = 24.sp,
    val veryVeryLarge: TextUnit = 28.sp,
)

val LocalTextSize = compositionLocalOf { TextSize() }
