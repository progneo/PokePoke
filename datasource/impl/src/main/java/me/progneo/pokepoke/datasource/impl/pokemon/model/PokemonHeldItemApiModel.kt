package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PokemonHeldItemApiModel(
    @Json(name = "item")
    val item: NamedAPIResourceApiModel?,
    @Json(name = "version_details")
    val versionDetails: List<PokemonHeldItemVersionApiModel>?
)
