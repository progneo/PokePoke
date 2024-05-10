package me.progneo.pokepoke.feature.home.data.repository

import javax.inject.Inject
import me.progneo.pokepoke.datasource.api.pokemon.datasource.PokemonDataSource
import me.progneo.pokepoke.datasource.api.pokemonList.datasource.PokemonListDataSource
import me.progneo.pokepoke.feature.home.data.mapper.toDomain
import me.progneo.pokepoke.feature.home.domain.model.pokemon.PokemonDomainModel
import me.progneo.pokepoke.feature.home.domain.model.pokemonList.PokemonListDomainModel
import me.progneo.pokepoke.feature.home.domain.repository.PokemonRepository

internal class PokemonListRepositoryImpl @Inject constructor(
    private val pokemonDataSource: PokemonDataSource,
    private val pokemonListDataSource: PokemonListDataSource
) : PokemonRepository {

    override suspend fun getPokemon(name: String): Result<PokemonDomainModel> {
        return pokemonDataSource.getPokemon(name).fold(
            onSuccess = { pokemonDataModel ->
                val pokemon = pokemonDataModel.toDomain()
                Result.success(pokemon)
            },
            onFailure = { Result.failure(it) }
        )
    }

    override suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListDomainModel> {
        return pokemonListDataSource.getPokemonList(limit = limit, offset = offset).fold(
            onSuccess = { pokemonListDataModel ->
                val pokemonList =
                    pokemonListDataModel.result.mapNotNull { getPokemon(it).getOrNull() }
                Result.success(
                    PokemonListDomainModel(
                        count = pokemonListDataModel.count,
                        results = pokemonList
                    )
                )
            },
            onFailure = { Result.failure(it) }
        )
    }
}
