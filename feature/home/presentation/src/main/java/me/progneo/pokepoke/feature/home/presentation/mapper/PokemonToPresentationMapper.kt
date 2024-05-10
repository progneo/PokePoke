package me.progneo.pokepoke.feature.home.presentation.mapper

import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonDomainModel
import me.progneo.pokepoke.feature.home.presentation.model.PokemonPresentationModel

internal fun PokemonDomainModel.toPresentation() = PokemonPresentationModel(
    name = this.name.toString(),
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
    } ?: emptyList()
)
