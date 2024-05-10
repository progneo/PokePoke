package me.progneo.pokepoke.feature.home.presentation.view.screen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import me.progneo.pokepoke.common.ui.AnimatedVisibility
import me.progneo.pokepoke.common.ui.ScreenEnterObserver
import me.progneo.pokepoke.feature.home.presentation.R
import me.progneo.pokepoke.feature.home.presentation.model.HomeViewAction
import me.progneo.pokepoke.feature.home.presentation.model.HomeViewState
import me.progneo.pokepoke.feature.home.presentation.view.widget.ErrorPanelContainer
import me.progneo.pokepoke.feature.home.presentation.view.widget.PokemonListContainer
import me.progneo.pokepoke.feature.home.presentation.view.widget.PokemonListPlaceholderContainer
import me.progneo.pokepoke.feature.home.presentation.viewmodel.HomeViewModel

@Composable
internal fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    ScreenEnterObserver {
        viewModel.onAction(HomeViewAction.LoadPokemonList)
    }

    LaunchedEffect(key1 = viewModel.state) {
        Log.i("state", viewModel.state.toString())
    }

    HomeScreen(state = viewModel.state, onAction = viewModel::onAction)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun HomeScreen(state: HomeViewState, onAction: (HomeViewAction) -> Unit) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.home_top_app_bar_title)) },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(innerPadding)
        ) {
            AnimatedVisibility(visible = state is HomeViewState.Success, delayMillis = 300) {
                if (state is HomeViewState.Success) {
                    PokemonListContainer(
                        state.pokemonList,
                        state.isLoading,
                        onEndReached = { onAction(HomeViewAction.LoadPokemonList) },
                        onPokemonClick = { onAction(HomeViewAction.SelectPokemon(it)) }
                    )
                }
            }
            AnimatedVisibility(visible = state is HomeViewState.Loading, delayMillis = 300) {
                PokemonListPlaceholderContainer()
            }
            AnimatedVisibility(visible = state is HomeViewState.Error, delayMillis = 300) {
                ErrorPanelContainer(
                    text = stringResource(
                        R.string.home_error_panel_description
                    ),
                    onReloadClick = {
                        onAction(HomeViewAction.LoadPokemonList)
                    }
                )
            }
        }
    }
}
