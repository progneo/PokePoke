package me.progneo.pokepoke.feature.detail.domain.model

data class PokemonTypePastDomainModel(
    val generation: String?,
    val types: List<PokemonTypeDomainModel>?
)
