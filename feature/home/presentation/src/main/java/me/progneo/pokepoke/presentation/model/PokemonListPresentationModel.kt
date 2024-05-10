package me.progneo.pokepoke.presentation.model

data class PokemonListPresentationModel(
    val count: Int,
    val results: List<PokemonPresentationModel>
)
