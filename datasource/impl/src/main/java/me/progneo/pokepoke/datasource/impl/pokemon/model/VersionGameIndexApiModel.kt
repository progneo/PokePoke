package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class VersionGameIndexApiModel(
    @Json(name = "game_index")
    val gameIndex: Int?,
    @Json(name = "version")
    val version: NamedAPIResourceApiModel?
)
