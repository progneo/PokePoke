package me.progneo.pokepoke.common.core.extension

import java.util.*

fun String.capitalize() = this.replaceFirstChar { firstChat ->
    if (firstChat.isLowerCase()) firstChat.titlecase(Locale.getDefault()) else firstChat.toString()
}
