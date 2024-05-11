package me.progneo.pokepoke.common.core.extension

import java.util.*

fun String.capitalize() = this.replaceFirstChar {
    if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString()
}
