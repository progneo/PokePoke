package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PokemonMoveVersionApiModel(
    @Json(name = "move_learn_method")
    val moveLearnMethod: NamedAPIResourceApiModel?,
    @Json(name = "version_group")
    val versionGroup: NamedAPIResourceApiModel?,
    @Json(name = "level_learned_at")
    val levelLearnedAt: Int?
)
