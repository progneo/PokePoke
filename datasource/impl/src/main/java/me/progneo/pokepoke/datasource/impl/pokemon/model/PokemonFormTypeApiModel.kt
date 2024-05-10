package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PokemonFormTypeApiModel(
    @Json(name = "slot")
    val slot: Int?,
    @Json(name = "type")
    val type: NamedAPIResourceApiModel?
)
