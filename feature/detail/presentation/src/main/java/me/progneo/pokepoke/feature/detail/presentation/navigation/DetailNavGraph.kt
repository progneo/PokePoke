package me.progneo.pokepoke.feature.detail.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import me.progneo.pokepoke.feature.detail.presentation.view.screen.DetailScreen

const val DETAIL_ROUTE = "DETAIL_SCREEN"

fun NavGraphBuilder.detailScreen(onBackClick: () -> Unit) {
    composable(route = "$DETAIL_ROUTE/{pokemonName}") {
        DetailScreen(onBackClick)
    }
}
