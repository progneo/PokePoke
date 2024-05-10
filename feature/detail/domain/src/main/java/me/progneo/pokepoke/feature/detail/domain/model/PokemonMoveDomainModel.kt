package me.progneo.pokepoke.feature.detail.domain.model

data class PokemonMoveDomainModel(
    val move: String?,
    val versionGroupDetails: List<PokemonMoveVersionDomainModel>?
)
