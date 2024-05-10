package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PokemonMoveApiModel(
    @Json(name = "move")
    val move: NamedAPIResourceApiModel?,
    @Json(name = "version_group_details")
    val versionGroupDetails: List<PokemonMoveVersionApiModel>?
)
