package me.progneo.pokepoke.feature.detail.domain.usecase

import me.progneo.pokepoke.feature.detail.domain.model.PokemonDomainModel

interface GetPokemonUseCase {
    suspend operator fun invoke(name: String): Result<PokemonDomainModel>
}
