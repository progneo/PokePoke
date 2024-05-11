package me.progneo.pokepoke.feature.detail.presentation.view.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import me.progneo.pokepoke.common.presentaion.shimmerEffect
import me.progneo.pokepoke.feature.detail.presentation.view.content.SingleValueDescriptionRowPlaceholder

@Composable
internal fun PokemonDetailPlaceholderContainer() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .shimmerEffect()
            )
            Row(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp, 6.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .shimmerEffect()
                )
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(5) { SingleValueDescriptionRowPlaceholder() }
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewPokemonDetailPlaceholderContainer() {
    me.progneo.pokepoke.common.presentaion.theme.PokePokeTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(40.dp)
        ) {
            PokemonDetailPlaceholderContainer()
        }
    }
}
