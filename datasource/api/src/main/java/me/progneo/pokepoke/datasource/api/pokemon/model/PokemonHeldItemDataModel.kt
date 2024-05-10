package me.progneo.pokepoke.datasource.api.pokemon.model

data class PokemonHeldItemDataModel(
    val item: String?,
    val versionDetails: List<PokemonHeldItemVersionDataModel>?
)
