package me.progneo.pokepoke.feature.detail.domain.repository

import me.progneo.pokepoke.feature.detail.domain.model.PokemonDomainModel

interface PokemonRepository {
    suspend fun getPokemon(name: String): Result<PokemonDomainModel>
}
