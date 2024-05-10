package me.progneo.pokepoke.datasource.impl.pokemonList.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PokemonListApiModel(
    @Json(name = "count")
    val count: Int?,
    @Json(name = "next")
    val next: String?,
    @Json(name = "previous")
    val previous: String?,
    @Json(name = "results")
    val results: List<NamedAPIResourceApiModel>?
)
