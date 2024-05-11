package me.progneo.pokepoke.feature.home.presentation.view.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import me.progneo.pokepoke.common.extension.capitalize
import me.progneo.pokepoke.common.presentaion.shimmerEffect
import me.progneo.pokepoke.feature.home.presentation.model.PokemonPresentationModel
import me.progneo.pokepoke.feature.home.presentation.view.widget.preview.PokemonPreviewParameterProvider

@Composable
internal fun PokemonListItem(
    name: String,
    spriteUrl: String?,
    onPokemonClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .clickable { onPokemonClick(name) }
            .background(colorScheme.surfaceVariant.copy(alpha = 0.3f))
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SubcomposeAsyncImage(
            model = spriteUrl,
            contentDescription = name,
            contentScale = ContentScale.Crop,
            loading = {
                Box(
                    modifier = Modifier.shimmerEffect()
                )
            },
            modifier = Modifier
                .size(64.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Text(
            text = name.capitalize(),
            style = typography.bodyLarge,
            color = colorScheme.onBackground,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@PreviewLightDark
@Composable
private fun PreviewDescriptionRow(
    @PreviewParameter(PokemonPreviewParameterProvider::class) pokemon: PokemonPresentationModel
) {
    me.progneo.pokepoke.common.presentaion.theme.PokePokeTheme {
        PokemonListItem(
            name = pokemon.name,
            spriteUrl = pokemon.sprites.firstOrNull(),
            onPokemonClick = {}
        )
    }
}
