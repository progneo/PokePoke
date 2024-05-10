package me.progneo.pokepoke.datasource.impl.pokemonList.mapper

import me.progneo.pokepoke.datasource.api.pokemonList.model.PokemonListDataModel
import me.progneo.pokepoke.datasource.impl.pokemonList.model.PokemonListApiModel

internal fun PokemonListApiModel.toData(): PokemonListDataModel {
    return PokemonListDataModel(
        count = this.count ?: 0,
        result = this.results?.mapNotNull { it.name } ?: emptyList()
    )
}
