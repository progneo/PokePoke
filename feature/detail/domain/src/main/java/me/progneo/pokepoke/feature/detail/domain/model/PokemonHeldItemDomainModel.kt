package me.progneo.pokepoke.feature.detail.domain.model

data class PokemonHeldItemDomainModel(
    val item: String?,
    val versionDetails: List<PokemonHeldItemVersionDomainModel>?
)
