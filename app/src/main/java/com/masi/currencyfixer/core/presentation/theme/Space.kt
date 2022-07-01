package com.masi.currencyfixer.core.presentation.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Space(
    val tiny: Dp = 2.dp,
    val verySmall: Dp = 4.dp,
    val small: Dp = 8.dp,
    val medium: Dp = 12.dp,
    val big: Dp = 16.dp,
    val large: Dp = 18.dp,
    val veryLarge: Dp = 24.dp,
    val veryVeryLarge: Dp = 32.dp,
)

val LocalSpace = compositionLocalOf { Space() }
