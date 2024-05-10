package me.progneo.pokepoke.presentation.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import me.progneo.pokepoke.common.ui.BaseViewModel
import me.progneo.pokepoke.domain.usecase.GetPokemonUseCase

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase
) : BaseViewModel() {

    fun onEnter() {
        getPokemonData()
    }

    private fun getPokemonData() {
        call(
            useCaseCall = { getPokemonUseCase("pikachu") }
        )
    }
}
