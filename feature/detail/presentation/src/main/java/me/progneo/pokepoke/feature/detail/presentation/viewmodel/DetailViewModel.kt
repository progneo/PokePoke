package me.progneo.pokepoke.feature.detail.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import me.progneo.pokepoke.common.ui.viewmodel.BaseViewModel
import me.progneo.pokepoke.feature.detail.domain.usecase.GetPokemonUseCase
import me.progneo.pokepoke.feature.detail.presentation.mapper.toPresentation
import me.progneo.pokepoke.feature.detail.presentation.model.DetailViewAction
import me.progneo.pokepoke.feature.detail.presentation.model.DetailViewState

@HiltViewModel
internal class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPokemonUseCase: GetPokemonUseCase
) : BaseViewModel() {

    private val pokemonName: String = checkNotNull(savedStateHandle.get<String>("pokemonName"))

    var state by mutableStateOf<DetailViewState>(DetailViewState.Loading)
        private set

    fun onAction(action: DetailViewAction) {
        when (action) {
            is DetailViewAction.LoadPokemon -> getPokemonData(pokemonName)
            else -> Unit
        }
    }

    private fun getPokemonData(pokemonName: String) {
        call(
            useCaseCall = { getPokemonUseCase(pokemonName) },
            onSuccess = { pokemonListDomainModel ->
                state = DetailViewState.Success(pokemonListDomainModel.toPresentation())
            },
            onError = {
                state = DetailViewState.Error(it)
            }
        )
    }
}
