package me.progneo.pokepoke.datasource.impl.pokemonList.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.progneo.pokepoke.datasource.impl.pokemonList.service.PokemonListService
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object PokemonListServiceModule {

    @Provides
    fun providePokemonListService(retrofit: Retrofit): PokemonListService =
        retrofit.create(PokemonListService::class.java)
}
