package me.progneo.pokepoke.feature.detail.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import me.progneo.pokepoke.feature.detail.data.repository.PokemonRepositoryImpl
import me.progneo.pokepoke.feature.detail.domain.repository.PokemonRepository

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

    @Binds
    @Singleton
    internal abstract fun bindPokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository
}
