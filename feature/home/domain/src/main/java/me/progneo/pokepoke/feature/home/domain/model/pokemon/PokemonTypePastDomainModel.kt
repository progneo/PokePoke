package me.progneo.pokepoke.feature.home.domain.model.pokemon

data class PokemonTypePastDomainModel(
    val generation: String?,
    val types: List<PokemonTypeDomainModel>?
)
