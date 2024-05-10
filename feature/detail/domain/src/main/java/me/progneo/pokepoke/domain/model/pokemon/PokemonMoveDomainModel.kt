package me.progneo.pokepoke.domain.model.pokemon

data class PokemonMoveDomainModel(
    val move: String?,
    val versionGroupDetails: List<PokemonMoveVersionDomainModel>?
)
