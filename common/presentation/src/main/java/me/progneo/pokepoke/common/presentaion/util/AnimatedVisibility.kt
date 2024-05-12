package me.progneo.pokepoke.common.presentaion.util

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable

private const val DEFAULT_DELAY_MILLIS = 300

@Composable
fun AnimatedVisibility(
    visible: Boolean = true,
    delayMillis: Int = DEFAULT_DELAY_MILLIS,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(delayMillis = delayMillis)),
        exit = fadeOut(),
        content = content
    )
}
