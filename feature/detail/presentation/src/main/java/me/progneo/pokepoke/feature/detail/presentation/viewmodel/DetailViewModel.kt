package me.progneo.pokepoke.feature.detail.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import me.progneo.pokepoke.feature.detail.domain.usecase.GetPokemonUseCase
import me.progneo.pokepoke.feature.detail.presentation.mapper.toPresentation
import me.progneo.pokepoke.feature.detail.presentation.model.DetailViewAction
import me.progneo.pokepoke.feature.detail.presentation.model.DetailViewState

@HiltViewModel
internal class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPokemonUseCase: GetPokemonUseCase
) : me.progneo.pokepoke.common.presentaion.viewmodel.BaseViewModel() {

    private val pokemonName: String = checkNotNull(savedStateHandle.get<String>("pokemonName"))

    private val _state = MutableStateFlow<DetailViewState>(DetailViewState.Loading)
    val state = _state.asStateFlow()

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
                _state.tryEmit(DetailViewState.Success(pokemonListDomainModel.toPresentation()))
            },
            onError = {
                _state.tryEmit(DetailViewState.Error(it))
            }
        )
    }
}
