package me.progneo.pokepoke.datasource.api.pokemonList.datasource

import me.progneo.pokepoke.datasource.api.pokemonList.model.PokemonListDataModel

interface PokemonListDataSource {
    suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListDataModel>
}
