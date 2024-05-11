package me.progneo.pokepoke.feature.home.presentation.view.screen

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import me.progneo.pokepoke.common.presentaion.ScreenEnterObserver
import me.progneo.pokepoke.common.presentaion.widget.ErrorPanelContainer
import me.progneo.pokepoke.feature.home.presentation.R
import me.progneo.pokepoke.feature.home.presentation.model.HomeViewAction
import me.progneo.pokepoke.feature.home.presentation.model.HomeViewState
import me.progneo.pokepoke.feature.home.presentation.view.widget.PokemonListContainer
import me.progneo.pokepoke.feature.home.presentation.view.widget.PokemonListPlaceholderContainer
import me.progneo.pokepoke.feature.home.presentation.viewmodel.HomeViewModel

@Composable
internal fun HomeScreen(
    onPokemonSelect: (String) -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    ScreenEnterObserver {
        viewModel.onAction(HomeViewAction.LoadPokemonList)
    }

    HomeScreen(state = state, onAction = { action ->
        when (action) {
            is HomeViewAction.SelectPokemon -> {
                onPokemonSelect(action.pokemonName)
            }

            else -> Unit
        }
        viewModel.onAction(action)
    })
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
            me.progneo.pokepoke.common.presentaion.AnimatedVisibility(
                visible = state is HomeViewState.Success
            ) {
                if (state is HomeViewState.Success) {
                    PokemonListContainer(
                        state.pokemonList,
                        state.isLoading,
                        onEndReached = { onAction(HomeViewAction.LoadPokemonList) },
                        onPokemonClick = { onAction(HomeViewAction.SelectPokemon(it)) }
                    )
                }
            }
            me.progneo.pokepoke.common.presentaion.AnimatedVisibility(
                visible = state is HomeViewState.Loading
            ) {
                PokemonListPlaceholderContainer()
            }
            me.progneo.pokepoke.common.presentaion.AnimatedVisibility(
                visible = state is HomeViewState.Error
            ) {
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
