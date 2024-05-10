package me.progneo.pokepoke.domain.usecase

import me.progneo.pokepoke.domain.model.pokemon.PokemonDomainModel

interface GetPokemonUseCase {
    suspend operator fun invoke(name: String): Result<PokemonDomainModel>
}
