package me.progneo.pokepoke.feature.home.domain.repository

import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemonList.PokemonListDomainModel

interface PokemonRepository {
    suspend fun getPokemon(name: String): Result<PokemonDomainModel>
    suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListDomainModel>
}
