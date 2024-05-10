package me.progneo.pokepoke.feature.home.domain.model.pokemon

data class PokemonMoveDomainModel(
    val move: String?,
    val versionGroupDetails: List<PokemonMoveVersionDomainModel>?
)
