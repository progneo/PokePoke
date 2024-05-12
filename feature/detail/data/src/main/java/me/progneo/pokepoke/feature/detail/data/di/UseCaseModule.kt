package me.progneo.pokepoke.feature.detail.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import me.progneo.pokepoke.feature.detail.data.usecase.GetPokemonUseCaseImpl
import me.progneo.pokepoke.feature.detail.domain.usecase.GetPokemonUseCase

@Module
@InstallIn(SingletonComponent::class)
internal abstract class UseCaseModule {

    @Binds
    @Singleton
    internal abstract fun bindGetPokemonUseCase(
        getPokemonUseCaseImpl: GetPokemonUseCaseImpl
    ): GetPokemonUseCase
}
