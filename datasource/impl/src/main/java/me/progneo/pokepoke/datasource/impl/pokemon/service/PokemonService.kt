package me.progneo.pokepoke.datasource.impl.pokemon.service

import me.progneo.pokepoke.datasource.impl.pokemon.model.PokemonApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

internal interface PokemonService {
    @GET("pokemon/{name}")
    suspend fun getPokemon(@Path("name") name: String): Response<PokemonApiModel>
}
