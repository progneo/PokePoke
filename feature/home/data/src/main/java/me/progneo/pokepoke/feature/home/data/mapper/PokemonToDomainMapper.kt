package me.progneo.pokepoke.feature.home.data.mapper

import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonDataModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonAbilityDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonCriesDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonHeldItemDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonHeldItemVersionDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonMoveDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonMoveVersionDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonSpritesDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonStatDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonTypeDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonTypePastDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemon.VersionGameIndexDomainModel

internal fun PokemonDataModel.toDomain() = PokemonDomainModel(
    id = this.id,
    name = this.name,
    baseExperience = this.baseExperience,
    height = this.height,
    isDefault = this.isDefault,
    order = this.order,
    weight = this.weight,
    abilities =
    this.abilities?.map { ability ->
        PokemonAbilityDomainModel(
            isHidden = ability.isHidden,
            slot = ability.slot,
            ability = ability.ability
        )
    },
    forms = this.forms,
    gameIndices =
    this.gameIndices?.map { gameIndex ->
        VersionGameIndexDomainModel(
            gameIndex = gameIndex.gameIndex,
            version = gameIndex.version
        )
    },
    heldItems =
    this.heldItems?.map { item ->
        PokemonHeldItemDomainModel(
            item = item.item,
            versionDetails =
            item.versionDetails?.map { version ->
                PokemonHeldItemVersionDomainModel(
                    version = version.version,
                    rarity = version.rarity
                )
            }
        )
    },
    locationAreaEncounters = this.locationAreaEncounters,
    moves =
    this.moves?.map { move ->
        PokemonMoveDomainModel(
            move = move.move,
            versionGroupDetails =
            move.versionGroupDetails?.map { version ->
                PokemonMoveVersionDomainModel(
                    moveLearnMethod = version.moveLearnMethod,
                    versionGroup = version.versionGroup,
                    levelLearnedAt = version.levelLearnedAt
                )
            }
        )
    },
    pastTypes =
    this.pastTypes?.map { pastType ->
        PokemonTypePastDomainModel(
            generation = pastType.generation,
            types =
            pastType.types?.map { type ->
                PokemonTypeDomainModel(
                    slot = type.slot,
                    type = type.type
                )
            }
        )
    },
    sprites =
    this.sprites?.let { sprites ->
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
    },
    cries =
    this.cries?.let { cries ->
        PokemonCriesDomainModel(
            latest = cries.latest,
            legacy = cries.legacy
        )
    },
    species = this.species,
    stats =
    this.stats?.map { stat ->
        PokemonStatDomainModel(
            stat = stat.stat,
            effort = stat.effort,
            baseStat = stat.baseStat
        )
    },
    types =
    this.types?.map { type ->
        PokemonTypeDomainModel(
            slot = type.slot,
            type = type.type
        )
    }
)
