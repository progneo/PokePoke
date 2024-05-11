package me.progneo.pokepoke.feature.detail.data

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import me.progneo.pokepoke.feature.detail.data.usecase.GetPokemonUseCaseImpl
import me.progneo.pokepoke.feature.detail.domain.model.PokemonDomainModel
import me.progneo.pokepoke.feature.detail.domain.repository.PokemonRepository
import me.progneo.pokepoke.feature.detail.domain.usecase.GetPokemonUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetPokemonUseCaseTest {

    private val mockRepository = mockk<PokemonRepository>()

    private lateinit var getPokemonUseCase: GetPokemonUseCase

    private val mockPokemonDomainModel = mockk<PokemonDomainModel>()

    @Before
    fun setup() {
        getPokemonUseCase = GetPokemonUseCaseImpl(mockRepository)
    }

    @Test
    fun `invoke returns Resource Success`() = runTest {
        coEvery { mockRepository.getPokemon("ditto") } returns Result.success(
            mockPokemonDomainModel
        )

        val result = getPokemonUseCase.invoke("ditto")

        assertTrue(result.isSuccess)
        result.onSuccess {
            assertEquals(mockPokemonDomainModel, it)
        }
    }
}
