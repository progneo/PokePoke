package me.progneo.pokepoke.presentation.mapper

import me.progneo.pokepoke.domain.model.pokemon.PokemonDomainModel
import me.progneo.pokepoke.presentation.model.PokemonPresentationModel

fun PokemonDomainModel.toPresentation() = PokemonPresentationModel(
    name = this.name,
    baseExperience = this.baseExperience,
    height = this.height,
    isDefault = this.isDefault,
    order = this.order,
    weight = this.weight,
    abilities = this.abilities?.mapNotNull { it.ability },
    forms = this.forms,
    moves = this.moves?.mapNotNull { it.move },
    sprites = this.sprites?.let {
        listOfNotNull(
            it.frontDefault,
            it.backDefault,
            it.frontShiny,
            it.backShiny,
            it.frontFemale,
            it.backFemale,
            it.frontShinyFemale,
            it.backShinyFemale
        )
    },
    species = this.species,
    stats = this.stats?.map { Pair(it.stat ?: "", it.baseStat.toString()) },
    types = this.types?.mapNotNull { it.type }
)
