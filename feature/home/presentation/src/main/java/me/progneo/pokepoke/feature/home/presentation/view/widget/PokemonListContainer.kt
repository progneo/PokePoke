package me.progneo.pokepoke.feature.home.presentation.view.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.progneo.pokepoke.common.presentaion.util.AnimatedVisibility
import me.progneo.pokepoke.common.presentaion.util.OnBottomReached
import me.progneo.pokepoke.feature.home.presentation.model.PokemonPresentationModel
import me.progneo.pokepoke.feature.home.presentation.view.content.PokemonListItem
import me.progneo.pokepoke.feature.home.presentation.view.content.PokemonListItemPlaceholder

@Composable
internal fun PokemonListContainer(
    pokemonList: List<PokemonPresentationModel>,
    isLoading: Boolean,
    onEndReached: () -> Unit,
    onPokemonClick: (String) -> Unit
) {
    val listState = rememberLazyListState()
    listState.OnBottomReached(1) {
        onEndReached()
    }

    LazyColumn(
        state = listState,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, bottom = 80.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        items(items = pokemonList, key = { pokemon -> pokemon.name }) { pokemon ->
            PokemonListItem(
                pokemon.name,
                pokemon.sprites.firstOrNull(),
                onPokemonClick = { onPokemonClick(pokemon.name) }
            )
        }
        item {
            AnimatedVisibility(visible = isLoading) {
                PokemonListItemPlaceholder()
            }
        }
    }
}
