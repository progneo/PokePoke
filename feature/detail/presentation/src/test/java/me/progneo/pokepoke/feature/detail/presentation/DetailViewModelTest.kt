package me.progneo.pokepoke.feature.detail.presentation

import androidx.lifecycle.SavedStateHandle
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import me.progneo.pokepoke.feature.detail.domain.usecase.GetPokemonUseCase
import me.progneo.pokepoke.feature.detail.presentation.mapper.toPresentation
import me.progneo.pokepoke.feature.detail.presentation.model.DetailViewAction
import me.progneo.pokepoke.feature.detail.presentation.model.DetailViewState
import me.progneo.pokepoke.feature.detail.presentation.model.PokemonPresentationModel
import me.progneo.pokepoke.feature.detail.presentation.viewmodel.DetailViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test

private const val POKEMON_NAME = "clefairy"

@OptIn(ExperimentalCoroutinesApi::class)
class DetailViewModelTest {

    private val testDispatcher = StandardTestDispatcher()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule(testDispatcher)

    private val getPokemonUseCase = mockk<GetPokemonUseCase>()
    private lateinit var detailViewModel: DetailViewModel

    @Before
    fun setup() {
        detailViewModel = DetailViewModel(
            savedStateHandle = SavedStateHandle().apply {
                set("pokemonName", POKEMON_NAME)
            },
            getPokemonUseCase = getPokemonUseCase
        )
    }

    @Test
    fun `getPokemon emits success state`() = runTest {
        val mockedPokemonPresentationModel = mockk<PokemonPresentationModel>()

        coEvery {
            getPokemonUseCase(POKEMON_NAME).onSuccess { pokemon ->
                return@coEvery pokemon.toPresentation()
            }
        } returns mockedPokemonPresentationModel

        CoroutineScope(testDispatcher).launch {
            detailViewModel.state.collect {
                if (it is DetailViewState.Success) {
                    assert(it.pokemon == mockedPokemonPresentationModel)
                }
            }
        }

        detailViewModel.onAction(DetailViewAction.LoadPokemon)
    }
}
