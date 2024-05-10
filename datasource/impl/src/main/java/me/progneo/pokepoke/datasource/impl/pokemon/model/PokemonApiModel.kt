package me.progneo.pokepoke.datasource.impl.pokemon.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
internal data class PokemonApiModel(
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "base_experience")
    val baseExperience: Int?,
    @Json(name = "height")
    val height: Int?,
    @Json(name = "is_default")
    val isDefault: Boolean?,
    @Json(name = "order")
    val order: Int?,
    @Json(name = "weight")
    val weight: Int?,
    @Json(name = "abilities")
    val abilities: List<PokemonAbilityApiModel>?,
    @Json(name = "forms")
    val forms: List<NamedAPIResourceApiModel>?,
    @Json(name = "game_indices")
    val gameIndices: List<VersionGameIndexApiModel>?,
    @Json(name = "held_items")
    val heldItems: List<PokemonHeldItemApiModel>?,
    @Json(name = "location_area_encounters")
    val locationAreaEncounters: String?,
    @Json(name = "moves")
    val moves: List<PokemonMoveApiModel>?,
    @Json(name = "past_types")
    val pastTypes: List<PokemonTypePastApiModel>?,
    @Json(name = "sprites")
    val sprites: PokemonSpritesApiModel?,
    @Json(name = "cries")
    val cries: PokemonCriesApiModel?,
    @Json(name = "species")
    val species: NamedAPIResourceApiModel?,
    @Json(name = "stats")
    val stats: List<PokemonStatApiModel>?,
    @Json(name = "types")
    val types: List<PokemonTypeApiModel>?
)
