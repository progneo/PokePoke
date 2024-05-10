package me.progneo.pokepoke.datasource.impl.pokemonList.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class NamedAPIResourceApiModel(
    @Json(name = "name")
    val name: String?,
    @Json(name = "url")
    val url: String?
)
