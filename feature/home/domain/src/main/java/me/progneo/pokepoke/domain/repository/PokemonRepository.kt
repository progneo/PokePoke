package me.progneo.pokepoke.domain.repository

import me.progneo.pokepoke.domain.model.pokemon.PokemonDomainModel
import me.progneo.pokepoke.domain.model.pokemonList.PokemonListDomainModel

interface PokemonRepository {
    fun getPokemon(name: String): Result<PokemonDomainModel>
    fun getPokemonList(limit: Int, offset: Int): Result<PokemonListDomainModel>
}
