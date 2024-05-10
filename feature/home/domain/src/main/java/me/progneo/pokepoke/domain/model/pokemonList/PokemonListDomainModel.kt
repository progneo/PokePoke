package me.progneo.pokepoke.domain.model.pokemonList

import me.progneo.pokepoke.domain.model.pokemon.PokemonDomainModel

data class PokemonListDomainModel(
    val count: Int,
    val results: List<PokemonDomainModel>
)
