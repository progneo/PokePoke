package me.progneo.pokepoke.feature.detail.presentation.model

interface DetailViewAction {
    data object LoadPokemon : DetailViewAction
    data object GoBack : DetailViewAction
}
