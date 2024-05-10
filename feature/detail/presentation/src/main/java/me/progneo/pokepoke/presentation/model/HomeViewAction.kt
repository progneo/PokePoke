package me.progneo.pokepoke.presentation.model

interface HomeViewAction {
    data class PokemonClick(val pokemonName: String) : HomeViewAction

    data object ScrollToEnd : HomeViewAction
}
