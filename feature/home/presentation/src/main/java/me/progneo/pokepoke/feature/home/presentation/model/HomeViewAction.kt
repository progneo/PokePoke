package me.progneo.pokepoke.feature.home.presentation.model

internal interface HomeViewAction {
    data class SelectPokemon(val pokemonName: String) : HomeViewAction

    data object LoadPokemonList : HomeViewAction
}
