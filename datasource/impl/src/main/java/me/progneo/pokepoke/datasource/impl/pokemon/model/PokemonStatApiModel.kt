package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PokemonStatApiModel(
    @Json(name = "stat")
    val stat: NamedAPIResourceApiModel?,
    @Json(name = "effort")
    val effort: Int?,
    @Json(name = "base_stat")
    val baseStat: Int?
)
