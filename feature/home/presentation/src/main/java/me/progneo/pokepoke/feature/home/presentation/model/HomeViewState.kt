package me.progneo.pokepoke.feature.home.presentation.model

internal sealed interface HomeViewState {
    data class Success(
        val pokemonList: List<PokemonPresentationModel>,
        val isLoading: Boolean,
        val currentPage: Int
    ) : HomeViewState

    data object Loading : HomeViewState

    data class Error(val throwable: Throwable) : HomeViewState
}
