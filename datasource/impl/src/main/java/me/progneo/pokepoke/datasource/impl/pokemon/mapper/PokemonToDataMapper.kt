package me.progneo.pokepoke.datasource.impl.pokemon.mapper

import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonAbilityDataModel
import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonCriesDataModel
import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonDataModel
import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonHeldItemDataModel
import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonHeldItemVersionDataModel
import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonMoveDataModel
import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonMoveVersionDataModel
import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonSpritesDataModel
import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonStatDataModel
import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonTypeDataModel
import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonTypePastDataModel
import me.progneo.pokepoke.datasource.api.pokemon.model.VersionGameIndexDataModel
import me.progneo.pokepoke.datasource.impl.pokemon.model.PokemonApiModel

internal fun PokemonApiModel.toData() = PokemonDataModel(
    id = this.id,
    name = this.name,
    baseExperience = this.baseExperience,
    height = this.height,
    isDefault = this.isDefault,
    order = this.order,
    weight = this.weight,
    abilities =
    this.abilities?.map { ability ->
        PokemonAbilityDataModel(
            isHidden = ability.isHidden,
            slot = ability.slot,
            ability = ability.ability?.name
        )
    },
    forms = this.forms?.mapNotNull { it.name },
    gameIndices =
    this.gameIndices?.map { gameIndex ->
        VersionGameIndexDataModel(
            gameIndex = gameIndex.gameIndex,
            version = gameIndex.version?.name
        )
    },
    heldItems =
    this.heldItems?.map { item ->
        PokemonHeldItemDataModel(
            item = item.item?.name,
            versionDetails =
            item.versionDetails?.map { version ->
                PokemonHeldItemVersionDataModel(
                    version = version.version?.name,
                    rarity = version.rarity
                )
            }
        )
    },
    locationAreaEncounters = this.locationAreaEncounters,
    moves =
    this.moves?.map { move ->
        PokemonMoveDataModel(
            move = move.move?.name,
            versionGroupDetails =
            move.versionGroupDetails?.map { version ->
                PokemonMoveVersionDataModel(
                    moveLearnMethod = version.moveLearnMethod?.name,
                    versionGroup = version.versionGroup?.name,
                    levelLearnedAt = version.levelLearnedAt
                )
            }
        )
    },
    pastTypes =
    this.pastTypes?.map { pastType ->
        PokemonTypePastDataModel(
            generation = pastType.generation?.name,
            types =
            pastType.types?.map { type ->
                PokemonTypeDataModel(
                    slot = type.slot,
                    type = type.type?.name
                )
            }
        )
    },
    sprites =
    this.sprites?.let { sprites ->
        PokemonSpritesDataModel(
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
        PokemonCriesDataModel(
            latest = cries.latest,
            legacy = cries.legacy
        )
    },
    species = this.species?.name,
    stats =
    this.stats?.map { stat ->
        PokemonStatDataModel(
            stat = stat.stat?.name,
            effort = stat.effort,
            baseStat = stat.baseStat
        )
    },
    types =
    this.types?.map { type ->
        PokemonTypeDataModel(
            slot = type.slot,
            type = type.type?.name
        )
    }
)
