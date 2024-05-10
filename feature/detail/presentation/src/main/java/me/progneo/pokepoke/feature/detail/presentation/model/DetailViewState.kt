package me.progneo.pokepoke.feature.detail.presentation.model

sealed interface DetailViewState {
    data class Success(val pokemon: PokemonPresentationModel) : DetailViewState

    data object Loading : DetailViewState

    data class Error(val throwable: Throwable?) : DetailViewState
}
