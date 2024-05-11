package me.progneo.pokepoke.feature.home.presentation.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import me.progneo.pokepoke.feature.home.domain.model.pokemonList.PokemonListRequestDomainModel
import me.progneo.pokepoke.feature.home.domain.usecase.GetPokemonListUseCase
import me.progneo.pokepoke.feature.home.presentation.mapper.toPresentation
import me.progneo.pokepoke.feature.home.presentation.model.HomeViewAction
import me.progneo.pokepoke.feature.home.presentation.model.HomeViewState

private const val PAGE_SIZE = 10

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : me.progneo.pokepoke.common.presentaion.viewmodel.BaseViewModel() {

    var state by mutableStateOf<HomeViewState>(HomeViewState.Loading)
        private set

    fun onAction(action: HomeViewAction) {
        when (action) {
            is HomeViewAction.LoadPokemonList -> getPokemonListData()
            else -> Unit
        }
    }

    private fun getPokemonListData() {
        if (state is HomeViewState.Success) {
            val currentList = (state as HomeViewState.Success).pokemonList
            val currentPage = (state as HomeViewState.Success).currentPage
            val offset = currentPage * PAGE_SIZE

            state = HomeViewState.Success(currentList, true, currentPage)

            call(
                useCaseCall = {
                    getPokemonListUseCase(
                        PokemonListRequestDomainModel(
                            limit = PAGE_SIZE,
                            offset = offset
                        )
                    )
                },
                onSuccess = { pokemonListDomainModel ->
                    val pokemonList = pokemonListDomainModel.results.map { it.toPresentation() }
                    state = HomeViewState.Success(currentList + pokemonList, false, currentPage + 1)
                },
                onError = {
                    state = HomeViewState.Error(it)
                }
            )
        } else {
            state = HomeViewState.Loading

            call(
                useCaseCall = {
                    getPokemonListUseCase(
                        PokemonListRequestDomainModel(
                            limit = PAGE_SIZE,
                            offset = 0
                        )
                    )
                },
                onSuccess = { pokemonListDomainModel ->
                    val pokemonList = pokemonListDomainModel.results.map { it.toPresentation() }
                    state = HomeViewState.Success(pokemonList, false, 1)
                },
                onError = {
                    state = HomeViewState.Error(it)
                }
            )
        }
    }
}
