package me.progneo.pokepoke.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named

@Module
@InstallIn(SingletonComponent::class)
object NetworkUrlModule {
    internal const val POKEAPI = "PokeAPI"

    private const val POKEAPI_URL = "https://pokeapi.co/api/v2/"

    @Provides
    @Named(POKEAPI)
    fun providesPokeapiUrl() = POKEAPI
}
