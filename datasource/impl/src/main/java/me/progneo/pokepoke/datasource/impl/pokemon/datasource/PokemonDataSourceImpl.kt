package me.progneo.pokepoke.datasource.impl.pokemon.datasource

import java.net.SocketTimeoutException
import javax.inject.Inject
import me.progneo.pokepoke.common.exception.DataException
import me.progneo.pokepoke.datasource.api.pokemon.datasource.PokemonDataSource
import me.progneo.pokepoke.datasource.api.pokemon.model.PokemonDataModel
import me.progneo.pokepoke.datasource.impl.pokemon.mapper.toData
import me.progneo.pokepoke.datasource.impl.pokemon.service.PokemonService

internal class PokemonDataSourceImpl @Inject constructor(
    private val pokemonService: PokemonService
) : PokemonDataSource {

    override fun getPokemon(name: String): Result<PokemonDataModel> {
        try {
            val response = pokemonService.getPokemon(name)

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
