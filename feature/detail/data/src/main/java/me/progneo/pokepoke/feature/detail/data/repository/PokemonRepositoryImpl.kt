package me.progneo.pokepoke.feature.detail.data.repository

import javax.inject.Inject
import me.progneo.pokepoke.datasource.api.pokemon.datasource.PokemonDataSource
import me.progneo.pokepoke.feature.detail.data.mapper.toDomain
import me.progneo.pokepoke.feature.detail.domain.model.PokemonDomainModel
import me.progneo.pokepoke.feature.detail.domain.repository.PokemonRepository

internal class PokemonRepositoryImpl
@Inject
constructor(
    private val pokemonDataSource: PokemonDataSource
) : PokemonRepository {

    private val cachedPokemonList = mutableListOf<PokemonDomainModel>()

    override suspend fun getPokemon(name: String): Result<PokemonDomainModel> {
        cachedPokemonList.find { it.name == name }?.let { return Result.success(it) }

        return pokemonDataSource.getPokemon(name).fold(
            onSuccess = { pokemonDataModel ->
                val pokemon = pokemonDataModel.toDomain()
                cachedPokemonList.add(pokemon)
                Result.success(pokemon)
            },
            onFailure = { Result.failure(it) }
        )
    }
}
