package me.progneo.pokepoke.domain.model.pokemon

data class PokemonSpritesDomainModel(
    val frontDefault: String?,
    val frontShiny: String?,
    val frontFemale: String?,
    val frontShinyFemale: String?,
    val backDefault: String?,
    val backShiny: String?,
    val backFemale: String?,
    val backShinyFemale: String?
)
