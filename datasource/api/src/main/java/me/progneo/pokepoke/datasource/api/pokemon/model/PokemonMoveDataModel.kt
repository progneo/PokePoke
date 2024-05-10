package me.progneo.pokepoke.datasource.api.pokemon.model

data class PokemonMoveDataModel(
    val move: String?,
    val versionGroupDetails: List<PokemonMoveVersionDataModel>?
)
