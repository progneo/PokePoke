package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json

internal data class VersionGameIndexApiModel(
    @Json(name = "game_index")
    val gameIndex: Int?,
    @Json(name = "version")
    val version: NamedAPIResourceApiModel?
)
