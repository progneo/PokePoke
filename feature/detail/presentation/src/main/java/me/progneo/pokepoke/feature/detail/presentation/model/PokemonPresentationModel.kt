package me.progneo.pokepoke.feature.detail.presentation.model

data class PokemonPresentationModel(
    val name: String,
    val baseExperience: Int?,
    val height: Int?,
    val isDefault: Boolean?,
    val order: Int?,
    val weight: Int?,
    val abilities: List<String>?,
    val forms: List<String>?,
    val moves: List<String>?,
    val sprites: List<String>,
    val species: String?,
    val stats: List<Pair<String, String>>?,
    val types: List<String>?
)
