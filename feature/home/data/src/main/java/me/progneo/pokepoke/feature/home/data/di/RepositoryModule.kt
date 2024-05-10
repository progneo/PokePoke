package me.progneo.pokepoke.feature.home.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import me.progneo.pokepoke.feature.home.data.repository.PokemonListRepositoryImpl
import me.progneo.pokepoke.feature.home.domain.repository.PokemonRepository

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    internal abstract fun bindPokemonRepository(
        pokemonRepositoryImpl: PokemonListRepositoryImpl
    ): PokemonRepository
}
