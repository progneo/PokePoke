package me.progneo.pokepoke.datasource.impl.pokemonList.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import me.progneo.pokepoke.datasource.api.pokemonList.datasource.PokemonListDataSource
import me.progneo.pokepoke.datasource.impl.pokemonList.datasource.PokemonListDataSourceImpl

@Module
@InstallIn(SingletonComponent::class)
internal abstract class PokemonListDataSourceModule {

    @Binds
    @Singleton
    internal abstract fun bindPokemonListDataSourceModule(
        pokemonListDataSourceImpl: PokemonListDataSourceImpl
    ): PokemonListDataSource
}
