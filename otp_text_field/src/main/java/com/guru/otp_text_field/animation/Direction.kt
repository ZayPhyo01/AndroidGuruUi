package com.guru.otp_text_field.animation

import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring

enum class Direction {
    TOP, START
}


fun slideInFadeIn() = slideInHorizontally(
    animationSpec = spring(
        dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium
    )
) + fadeIn()

fun slideOutFadeOut() = slideOutHorizontally(
    spring(
        dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium
    )
) + fadeOut()

fun slideDownFadeIn() = slideInVertically(
    spring(
        dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium
    )
) + fadeIn()

fun slideUpFadeOut() = slideOutVertically(
    spring(
        dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium
    )
) + fadeOut()



