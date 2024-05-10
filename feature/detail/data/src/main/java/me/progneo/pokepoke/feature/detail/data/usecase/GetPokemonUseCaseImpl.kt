package me.progneo.pokepoke.feature.detail.data.usecase

import javax.inject.Inject
import me.progneo.pokepoke.feature.detail.domain.model.PokemonDomainModel
import me.progneo.pokepoke.feature.detail.domain.repository.PokemonRepository
import me.progneo.pokepoke.feature.detail.domain.usecase.GetPokemonUseCase

internal class GetPokemonUseCaseImpl @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : GetPokemonUseCase {

    override suspend fun invoke(name: String): Result<PokemonDomainModel> {
        return pokemonRepository.getPokemon(name = name)
    }
}
