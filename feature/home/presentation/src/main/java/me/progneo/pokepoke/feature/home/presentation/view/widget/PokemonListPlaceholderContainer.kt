package me.progneo.pokepoke.feature.home.presentation.view.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.progneo.pokepoke.feature.home.presentation.view.content.PokemonListItemPlaceholder

@Composable
internal fun PokemonListPlaceholderContainer() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        repeat(5) {
            PokemonListItemPlaceholder()
        }
    }
}

@Preview
@Composable
private fun PreviewPokemonListPlaceholderContainer() {
    PokemonListPlaceholderContainer()
}
