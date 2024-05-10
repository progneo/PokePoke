package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json

internal data class PokemonTypePastApiModel(
    @Json(name = "generation")
    val generation: NamedAPIResourceApiModel?,
    @Json(name = "types")
    val types: List<PokemonTypeApiModel>?
)
