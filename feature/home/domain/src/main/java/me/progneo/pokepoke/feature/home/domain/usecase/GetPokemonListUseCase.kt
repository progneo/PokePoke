package me.progneo.pokepoke.feature.home.domain.usecase

import me.progneo.pokepoke.feature.home.domain.model.pokemonList.PokemonListDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemonList.PokemonListRequestDomainModel

interface GetPokemonListUseCase {
    suspend operator fun invoke(
        params: PokemonListRequestDomainModel
    ): Result<PokemonListDomainModel>
}
