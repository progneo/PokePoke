package me.progneo.pokepoke.feature.home.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.progneo.pokepoke.feature.home.presentation.view.screen.HomeScreen

const val HOME_ROUTE = "HOME_SCREEN"

fun NavGraphBuilder.homeScreen(onPokemonSelect: (String) -> Unit) {
    composable(route = HOME_ROUTE) {
        HomeScreen(onPokemonSelect = onPokemonSelect)
    }
}
