package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PokemonHeldItemVersionApiModel(
    @Json(name = "version")
    val version: NamedAPIResourceApiModel?,
    @Json(name = "rarity")
    val rarity: Int?
)
