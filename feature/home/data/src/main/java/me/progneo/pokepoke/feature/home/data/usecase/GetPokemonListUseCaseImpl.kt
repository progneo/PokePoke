package me.progneo.pokepoke.feature.home.data.usecase

import javax.inject.Inject
import me.progneo.pokepoke.feature.home.domain.model.pokemonList.PokemonListDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemonList.PokemonListRequestDomainModel
import me.progneo.pokepoke.feature.home.domain.repository.PokemonRepository
import me.progneo.pokepoke.feature.home.domain.usecase.GetPokemonListUseCase

internal class GetPokemonListUseCaseImpl @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : GetPokemonListUseCase {

    override suspend fun invoke(
        params: PokemonListRequestDomainModel
    ): Result<PokemonListDomainModel> {
        return pokemonRepository.getPokemonList(limit = params.limit, offset = params.offset)
    }
}
