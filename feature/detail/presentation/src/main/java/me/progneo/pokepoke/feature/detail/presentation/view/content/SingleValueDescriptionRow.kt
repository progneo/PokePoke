package me.progneo.pokepoke.feature.detail.presentation.view.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import me.progneo.pokepoke.common.extension.capitalize
import me.progneo.pokepoke.common.ui.theme.PokePokeTheme

@Composable
internal fun SingleValueDescriptionRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(colorScheme.surfaceVariant.copy(alpha = 0.3f))
            .padding(16.dp)
    ) {
        Text(
            text = label,
            style = typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = colorScheme.onBackground,
            modifier = Modifier
                .width(128.dp)
        )
        Text(
            text = value.capitalize(),
            style = typography.bodyMedium,
            color = colorScheme.onBackground,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@PreviewLightDark
@Composable
private fun PreviewDescriptionRow() {
    PokePokeTheme {
        SingleValueDescriptionRow(label = "Name", value = "Pikachu")
    }
}
