package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PokemonTypePastApiModel(
    @Json(name = "generation")
    val generation: NamedAPIResourceApiModel?,
    @Json(name = "types")
    val types: List<PokemonTypeApiModel>?
)
