package me.progneo.pokepoke.datasource.impl.pokemonList.datasource

import java.net.SocketTimeoutException
import javax.inject.Inject
import me.progneo.pokepoke.common.exception.DataException
import me.progneo.pokepoke.datasource.api.pokemonList.datasource.PokemonListDataSource
import me.progneo.pokepoke.datasource.api.pokemonList.model.PokemonListDataModel
import me.progneo.pokepoke.datasource.impl.pokemonList.mapper.toData
import me.progneo.pokepoke.datasource.impl.pokemonList.service.PokemonListService

internal class PokemonListDataSourceImpl @Inject constructor(
    private val pokemonListService: PokemonListService
) : PokemonListDataSource {

    override suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListDataModel> {
        try {
            val response = pokemonListService.getPokemonList(limit = limit, offset = offset)

            if (!response.isSuccessful) {
                return Result.failure(
                    DataException(message = "Error ${response.code()}: ${response.message()}")
                )
            }

            val pokemonResponse = response.body()

            if (pokemonResponse != null) {
                return Result.success(pokemonResponse.toData())
            }

            return Result.failure(DataException(message = "An error occurred!"))
        } catch (requestTimeOutException: SocketTimeoutException) {
            return Result.failure(DataException(cause = requestTimeOutException))
        }
    }
}
