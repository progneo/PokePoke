package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json

internal data class PokemonTypeApiModel(
    @Json(name = "slot")
    val slot: Int?,
    @Json(name = "type")
    val type: NamedAPIResourceApiModel?
)
