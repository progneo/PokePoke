package me.progneo.pokepoke.feature.home.data.mapper

import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonDataModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonSpritesDomainModel

internal fun PokemonDataModel.toDomain() = PokemonDomainModel(
    name = this.name,
    sprites = this.sprites?.let { sprites ->
        PokemonSpritesDomainModel(
            frontDefault = sprites.frontDefault,
            frontShiny = sprites.frontShiny,
            frontFemale = sprites.frontFemale,
            frontShinyFemale = sprites.frontShinyFemale,
            backDefault = sprites.backDefault,
            backShiny = sprites.backShiny,
            backFemale = sprites.backFemale,
            backShinyFemale = sprites.backShinyFemale
        )
    }
)
