package me.progneo.pokepoke.feature.home.domain.model.pokemonList

import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonDomainModel

data class PokemonListDomainModel(
    val count: Int,
    val results: List<PokemonDomainModel>
)
