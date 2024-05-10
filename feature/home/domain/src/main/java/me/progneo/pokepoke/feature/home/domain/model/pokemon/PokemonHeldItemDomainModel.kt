package me.progneo.pokepoke.feature.home.domain.model.pokemon

data class PokemonHeldItemDomainModel(
    val item: String?,
    val versionDetails: List<PokemonHeldItemVersionDomainModel>?
)
