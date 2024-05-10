package me.progneo.pokepoke.common.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable

@Composable
fun AnimatedVisibility(
    visible: Boolean = true,
    delayMillis: Int = 300,
    content: @Composable AnimatedVisibilityScope.() -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(animationSpec = tween(delayMillis = delayMillis)),
        exit = fadeOut(),
        content = content
    )
}
