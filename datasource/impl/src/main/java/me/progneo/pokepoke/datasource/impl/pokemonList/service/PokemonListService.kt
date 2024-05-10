package me.progneo.pokepoke.datasource.impl.pokemonList.service

import me.progneo.pokepoke.datasource.impl.pokemonList.model.PokemonListApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface PokemonListService {
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<PokemonListApiModel>
}
