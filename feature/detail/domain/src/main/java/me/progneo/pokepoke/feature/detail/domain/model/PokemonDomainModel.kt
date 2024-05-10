package me.progneo.pokepoke.feature.detail.domain.model

data class PokemonDomainModel(
    val id: Int?,
    val name: String?,
    val baseExperience: Int?,
    val height: Int?,
    val isDefault: Boolean?,
    val order: Int?,
    val weight: Int?,
    val abilities: List<PokemonAbilityDomainModel>?,
    val forms: List<String>?,
    val gameIndices: List<VersionGameIndexDomainModel>?,
    val heldItems: List<PokemonHeldItemDomainModel>?,
    val locationAreaEncounters: String?,
    val moves: List<PokemonMoveDomainModel>?,
    val pastTypes: List<PokemonTypePastDomainModel>?,
    val sprites: PokemonSpritesDomainModel?,
    val cries: PokemonCriesDomainModel?,
    val species: String?,
    val stats: List<PokemonStatDomainModel>?,
    val types: List<PokemonTypeDomainModel>?
)
