package me.progneo.pokepoke.datasource.impl.pokemon.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import me.progneo.pokepoke.datasource.api.pokemon.datasource.PokemonDataSource
import me.progneo.pokepoke.datasource.impl.pokemon.datasource.PokemonDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
internal abstract class PokemonDataSourceModule {

    @Binds
    @Singleton
    internal abstract fun bindPokemonDataSourceModule(
        pokemonDataSourceImpl: PokemonDataSourceImpl
    ): PokemonDataSource
}
