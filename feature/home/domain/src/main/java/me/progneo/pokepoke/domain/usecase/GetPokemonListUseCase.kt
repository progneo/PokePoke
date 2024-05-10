package me.progneo.pokepoke.domain.usecase

import me.progneo.pokepoke.domain.model.pokemonList.PokemonListDomainModel
import me.progneo.pokepoke.domain.model.pokemonList.PokemonListRequestDomainModel

interface GetPokemonListUseCase {
    suspend operator fun invoke(
        params: PokemonListRequestDomainModel
    ): Result<PokemonListDomainModel>
}
