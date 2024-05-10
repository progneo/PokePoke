package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PokemonAbilityApiModel(
    @Json(name = "is_hidden")
    val isHidden: Boolean?,
    @Json(name = "slot")
    val slot: Int?,
    @Json(name = "ability")
    val ability: NamedAPIResourceApiModel?
)
