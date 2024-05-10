package me.progneo.pokepoke.feature.detail.presentation.view.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import me.progneo.pokepoke.common.ui.theme.PokePokeTheme
import me.progneo.pokepoke.feature.detail.presentation.model.PokemonPresentationModel
import me.progneo.pokepoke.feature.detail.presentation.view.content.DescriptionBlock
import me.progneo.pokepoke.feature.detail.presentation.view.content.ImageCarousel
import me.progneo.pokepoke.feature.detail.presentation.view.widget.preview.PokemonPreviewParameterProvider

@Composable
internal fun PokemonDetailContainer(pokemon: PokemonPresentationModel) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        ImageCarousel(imageUrlList = pokemon.sprites)
        DescriptionBlock(pokemon = pokemon, modifier = Modifier.padding(16.dp))
    }
}

@PreviewLightDark
@Composable
private fun PreviewPokemonDetailContainer(
    @PreviewParameter(PokemonPreviewParameterProvider::class) pokemon: PokemonPresentationModel
) {
    PokePokeTheme {
        Box(
            modifier = Modifier
                .background(colorScheme.background)
                .padding(40.dp)
        ) {
            PokemonDetailContainer(pokemon)
        }
    }
}
