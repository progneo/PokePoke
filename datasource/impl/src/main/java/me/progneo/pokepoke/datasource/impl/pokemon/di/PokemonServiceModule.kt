package me.progneo.pokepoke.datasource.impl.pokemon.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.progneo.pokepoke.datasource.impl.pokemon.service.PokemonService
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object PokemonServiceModule {

    @Provides
    fun providePokemonService(retrofit: Retrofit): PokemonService =
        retrofit.create(PokemonService::class.java)
}
