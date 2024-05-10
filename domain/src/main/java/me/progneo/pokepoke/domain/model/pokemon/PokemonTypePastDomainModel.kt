package me.progneo.pokepoke.domain.model.pokemon

data class PokemonTypePastDomainModel(
    val generation: String?,
    val types: List<PokemonTypeDomainModel>?
)
