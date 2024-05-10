package me.progneo.pokepoke.feature.detail.presentation.view.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import me.progneo.pokepoke.common.extension.capitalize
import me.progneo.pokepoke.common.ui.AnimatedVisibility
import me.progneo.pokepoke.common.ui.ScreenEnterObserver
import me.progneo.pokepoke.common.ui.shimmerEffect
import me.progneo.pokepoke.common.ui.theme.PokePokeTheme
import me.progneo.pokepoke.common.ui.widget.ErrorPanelContainer
import me.progneo.pokepoke.feature.detail.presentation.R
import me.progneo.pokepoke.feature.detail.presentation.model.DetailViewAction
import me.progneo.pokepoke.feature.detail.presentation.model.DetailViewState
import me.progneo.pokepoke.feature.detail.presentation.model.PokemonPresentationModel
import me.progneo.pokepoke.feature.detail.presentation.view.widget.PokemonDetailContainer
import me.progneo.pokepoke.feature.detail.presentation.view.widget.PokemonDetailPlaceholderContainer
import me.progneo.pokepoke.feature.detail.presentation.view.widget.preview.PokemonPreviewParameterProvider
import me.progneo.pokepoke.feature.detail.presentation.viewmodel.DetailViewModel

@Composable
internal fun DetailScreen(onBackClick: () -> Unit, viewModel: DetailViewModel = hiltViewModel()) {
    ScreenEnterObserver {
        viewModel.onAction(DetailViewAction.LoadPokemon)
    }

    DetailScreen(state = viewModel.state, onAction = { action ->
        when (action) {
            is DetailViewAction.GoBack -> {
                onBackClick()
            }

            else -> Unit
        }
        viewModel.onAction(action)
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DetailScreen(state: DetailViewState, onAction: (DetailViewAction) -> Unit) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                title = {
                    AnimatedVisibility(visible = state is DetailViewState.Loading) {
                        Text(
                            text = "",
                            modifier = Modifier
                                .width(120.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .shimmerEffect()
                        )
                    }
                    AnimatedVisibility(visible = state is DetailViewState.Success) {
                        Text(
                            text = (state as DetailViewState.Success).pokemon.name.capitalize()
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { onAction(DetailViewAction.GoBack) }) {
                        Icon(
                            painter = painterResource(R.drawable.icon_arrow_back),
                            contentDescription = null
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(innerPadding)
        ) {
            AnimatedVisibility(visible = state is DetailViewState.Success) {
                PokemonDetailContainer(pokemon = (state as DetailViewState.Success).pokemon)
            }
            AnimatedVisibility(visible = state is DetailViewState.Loading) {
                PokemonDetailPlaceholderContainer()
            }
            AnimatedVisibility(visible = state is DetailViewState.Error) {
                ErrorPanelContainer(
                    text = stringResource(
                        R.string.detail_error_panel_description
                    ),
                    onReloadClick = {
                        onAction(DetailViewAction.LoadPokemon)
                    }
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewDetailScreenWithData(
    @PreviewParameter(PokemonPreviewParameterProvider::class) pokemon: PokemonPresentationModel
) {
    PokePokeTheme {
        DetailScreen(
            state = DetailViewState.Success(pokemon),
            onAction = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun PreviewDetailScreenError() {
    PokePokeTheme {
        DetailScreen(
            state = DetailViewState.Error(Throwable()),
            onAction = {}
        )
    }
}

@PreviewLightDark
@Composable
private fun PreviewDetailScreenLoading() {
    PokePokeTheme {
        DetailScreen(
            state = DetailViewState.Loading,
            onAction = {}
        )
    }
}
