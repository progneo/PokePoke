package me.progneo.pokepoke.presentation.model

interface HomeViewAction {
    data class SelectPokemon(val pokemonName: String) : HomeViewAction

    data object ScrollToEnd : HomeViewAction
}
