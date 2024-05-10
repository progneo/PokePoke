package me.progneo.pokepoke.common.ui.widget

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import me.progneo.pokepoke.common.R
import me.progneo.pokepoke.common.ui.content.IconWithDescription
import me.progneo.pokepoke.common.ui.theme.PokePokeTheme

@Composable
fun ErrorPanelContainer(text: String, onReloadClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(
            space = 24.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconWithDescription(
            iconPainter = painterResource(R.drawable.icon_heart_broken),
            text = text
        )
        FilledTonalButton(onClick = onReloadClick) {
            Text(stringResource(R.string.common_error_panel_reload_button_text))
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewErrorPanelContainer() {
    PokePokeTheme {
        ErrorPanelContainer(text = "Error message", onReloadClick = {})
    }
}
