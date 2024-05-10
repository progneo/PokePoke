package me.progneo.pokepoke.data.usecase

import javax.inject.Inject
import me.progneo.pokepoke.domain.model.pokemonList.PokemonListDomainModel
import me.progneo.pokepoke.domain.model.pokemonList.PokemonListRequestDomainModel
import me.progneo.pokepoke.domain.repository.PokemonRepository
import me.progneo.pokepoke.domain.usecase.GetPokemonListUseCase

class GetPokemonListUseCaseImpl @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : GetPokemonListUseCase {

    override suspend fun invoke(
        params: PokemonListRequestDomainModel
    ): Result<PokemonListDomainModel> {
        return pokemonRepository.getPokemonList(limit = params.limit, offset = params.offset)
    }
}
