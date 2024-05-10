package me.progneo.pokepoke.presentation.view.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import me.progneo.pokepoke.presentation.viewmodel.HomeViewModel

@Composable
internal fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    HomeScreen()
}

@Composable
internal fun HomeScreen() {
    Box {
        Text(text = "a")
    }
}
