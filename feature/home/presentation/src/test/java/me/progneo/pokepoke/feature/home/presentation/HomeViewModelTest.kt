package me.progneo.pokepoke.feature.home.presentation

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import me.progneo.pokepoke.common.presentaion.test.MainDispatcherRule
import me.progneo.pokepoke.feature.home.domain.model.pokemonList.PokemonListRequestDomainModel
import me.progneo.pokepoke.feature.home.domain.usecase.GetPokemonListUseCase
import me.progneo.pokepoke.feature.home.presentation.mapper.toPresentation
import me.progneo.pokepoke.feature.home.presentation.model.HomeViewAction
import me.progneo.pokepoke.feature.home.presentation.model.HomeViewState
import me.progneo.pokepoke.feature.home.presentation.model.PokemonPresentationModel
import me.progneo.pokepoke.feature.home.presentation.viewmodel.HomeViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class HomeViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule(testDispatcher)

    private val getPokemonListUseCase = mockk<GetPokemonListUseCase>()
    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setup() {
        homeViewModel = HomeViewModel(getPokemonListUseCase)
    }

    @Test
    fun `getPokemonList emits success state`() = runTest {
        val mockedPokemonListPresentationModel = mockk<List<PokemonPresentationModel>>()
        val pokemonListRequestDomainModel = PokemonListRequestDomainModel(limit = 10, offset = 0)

        coEvery {
            getPokemonListUseCase(pokemonListRequestDomainModel).onSuccess { pokemonList ->
                return@coEvery pokemonList.results.map { pokemon ->
                    pokemon.toPresentation()
                }
            }
        } returns mockedPokemonListPresentationModel

        CoroutineScope(testDispatcher).launch {
            homeViewModel.state.collect {
                if (it is HomeViewState.Success) {
                    assert(it.pokemonList == mockedPokemonListPresentationModel)
                }
            }
        }

        homeViewModel.onAction(HomeViewAction.LoadPokemonList)
    }
}
