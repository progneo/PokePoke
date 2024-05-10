package me.progneo.pokepoke.datasource.api.pokemon.datasource

import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonDataModel

interface PokemonDataSource {
    fun getPokemon(name: String): Result<PokemonDataModel>
}
