package me.progneo.pokepoke.feature.home.presentation.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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

    private val _state = MutableStateFlow<HomeViewState>(HomeViewState.Loading)
    val state = _state.asStateFlow()

    fun onAction(action: HomeViewAction) {
        when (action) {
            is HomeViewAction.LoadPokemonList -> getPokemonListData()
            else -> Unit
        }
    }

    private fun getPokemonListData() {
        if (_state.value is HomeViewState.Success) {
            val currentList = (_state.value as HomeViewState.Success).pokemonList
            val currentPage = (_state.value as HomeViewState.Success).currentPage
            val offset = currentPage * PAGE_SIZE

            _state.tryEmit(HomeViewState.Success(currentList, true, currentPage))

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
                    _state.tryEmit(
                        HomeViewState.Success(
                            currentList + pokemonList,
                            false,
                            currentPage + 1
                        )
                    )
                },
                onError = {
                    _state.tryEmit(HomeViewState.Error(it))
                }
            )
        } else {
            _state.tryEmit(HomeViewState.Loading)

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
                    _state.tryEmit(HomeViewState.Success(pokemonList, false, 1))
                },
                onError = {
                    _state.tryEmit(HomeViewState.Error(it))
                }
            )
        }
    }
}
