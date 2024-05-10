package me.progneo.pokepoke.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import me.progneo.pokepoke.feature.home.presentation.navigation.HOME_ROUTE
import me.progneo.pokepoke.feature.home.presentation.navigation.homeScreen

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE,
        modifier = Modifier
    ) {
        homeScreen(navController)
    }
}
