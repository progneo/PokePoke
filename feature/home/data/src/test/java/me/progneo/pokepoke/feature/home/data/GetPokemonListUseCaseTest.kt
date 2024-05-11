package me.progneo.pokepoke.feature.home.data

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import me.progneo.pokepoke.feature.home.data.usecase.GetPokemonListUseCaseImpl
import me.progneo.pokepoke.feature.home.domain.model.pokemonList.PokemonListDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemonList.PokemonListRequestDomainModel
import me.progneo.pokepoke.feature.home.domain.repository.PokemonRepository
import me.progneo.pokepoke.feature.home.domain.usecase.GetPokemonListUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetPokemonListUseCaseTest {

    private val mockRepository = mockk<PokemonRepository>()

    private lateinit var getPokemonListUseCase: GetPokemonListUseCase

    private val pokemonListRequestDomainModel = PokemonListRequestDomainModel(limit = 1, offset = 0)
    private val mockPokemonListDomainModel = mockk<PokemonListDomainModel>()

    @Before
    fun setup() {
        getPokemonListUseCase = GetPokemonListUseCaseImpl(mockRepository)
    }

    @Test
    fun `invoke returns Resource Success`() = runTest {
        coEvery { mockRepository.getPokemonList(limit = 1, offset = 0) } returns Result.success(
            mockPokemonListDomainModel
        )

        val result = getPokemonListUseCase.invoke(pokemonListRequestDomainModel)

        assertTrue(result.isSuccess)
        result.onSuccess {
            assertEquals(mockPokemonListDomainModel, it)
        }
    }
}
