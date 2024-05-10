package me.progneo.pokepoke.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import me.progneo.pokepoke.common.ui.BaseViewModel
import me.progneo.pokepoke.domain.model.pokemonList.PokemonListRequestDomainModel
import me.progneo.pokepoke.domain.usecase.GetPokemonListUseCase
import me.progneo.pokepoke.presentation.model.HomeViewAction
import me.progneo.pokepoke.presentation.model.HomeViewState

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : BaseViewModel() {

    var state by mutableStateOf<HomeViewState>(HomeViewState.Loading)
        private set

    fun onEnter() {
        getPokemonListData()
    }

    fun onAction(action: HomeViewAction) {
        when (action) {
            is HomeViewAction.PokemonClick -> Unit
            is HomeViewAction.ScrollToEnd -> getPokemonListData()
            else -> Unit
        }
    }

    private fun getPokemonListData() {
        call(
            useCaseCall = {
                getPokemonListUseCase(
                    PokemonListRequestDomainModel(
                        limit = 0,
                        offset = 0
                    )
                )
            }
        )
    }

    fun onPokemonSelectAction() {
    }
}
