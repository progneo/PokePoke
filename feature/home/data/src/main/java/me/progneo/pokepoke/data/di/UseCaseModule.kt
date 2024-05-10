package me.progneo.pokepoke.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import me.progneo.pokepoke.data.usecase.GetPokemonListUseCaseImpl
import me.progneo.pokepoke.domain.usecase.GetPokemonListUseCase

@Module
@InstallIn(SingletonComponent::class)
abstract class UseCaseModule {

    @Binds
    @Singleton
    internal abstract fun bindGetProductListUseCase(
        getPokemonListUseCaseImpl: GetPokemonListUseCaseImpl
    ): GetPokemonListUseCase
}
