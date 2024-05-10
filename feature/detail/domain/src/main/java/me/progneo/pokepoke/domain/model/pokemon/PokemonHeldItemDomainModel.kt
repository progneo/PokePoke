package me.progneo.pokepoke.domain.model.pokemon

data class PokemonHeldItemDomainModel(
    val item: String?,
    val versionDetails: List<PokemonHeldItemVersionDomainModel>?
)
