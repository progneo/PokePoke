package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PokemonCriesApiModel(
    @Json(name = "latest")
    val latest: String?,
    @Json(name = "legacy")
    val legacy: String?
)
