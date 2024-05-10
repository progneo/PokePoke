package me.progneo.pokepoke.datasource.api.pokemon.model

data class PokemonDataModel(
    val id: Int?,
    val name: String?,
    val baseExperience: Int?,
    val height: Int?,
    val isDefault: Boolean?,
    val order: Int?,
    val weight: Int?,
    val abilities: List<PokemonAbilityDataModel>?,
    val forms: List<String>?,
    val gameIndices: List<VersionGameIndexDataModel>?,
    val heldItems: List<PokemonHeldItemDataModel>?,
    val locationAreaEncounters: String?,
    val moves: List<PokemonMoveDataModel>?,
    val pastTypes: List<PokemonTypePastDataModel>?,
    val sprites: PokemonSpritesDataModel?,
    val cries: PokemonCriesDataModel?,
    val species: String?,
    val stats: List<PokemonStatDataModel>?,
    val types: List<PokemonTypeDataModel>?
)
