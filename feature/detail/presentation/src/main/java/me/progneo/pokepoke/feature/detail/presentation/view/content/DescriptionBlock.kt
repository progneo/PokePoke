package me.progneo.pokepoke.feature.detail.presentation.view.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import me.progneo.pokepoke.common.ui.theme.PokePokeTheme
import me.progneo.pokepoke.feature.detail.presentation.model.PokemonPresentationModel
import me.progneo.pokepoke.feature.detail.presentation.view.widget.preview.PokemonPreviewParameterProvider

@Composable
internal fun DescriptionBlock(pokemon: PokemonPresentationModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (!pokemon.stats.isNullOrEmpty()) {
            MultipleValueDescriptionRow(
                label = "Stats",
                values = pokemon.stats.map { "${it.first}: ${it.second}" }
            )
        }
        pokemon.species?.let { SingleValueDescriptionRow(label = "Species", value = it) }
        if (!pokemon.forms.isNullOrEmpty()) {
            MultipleValueDescriptionRow(label = "Forms", values = pokemon.forms)
        }
        if (!pokemon.abilities.isNullOrEmpty()) {
            MultipleValueDescriptionRow(label = "Abilities", values = pokemon.abilities)
        }
        if (!pokemon.types.isNullOrEmpty()) {
            MultipleValueDescriptionRow(label = "Types", values = pokemon.types)
        }
        pokemon.baseExperience?.let {
            SingleValueDescriptionRow(label = "Base Experience", value = it.toString())
        }
        pokemon.height?.let { SingleValueDescriptionRow(label = "Height", value = it.toString()) }
        pokemon.weight?.let { SingleValueDescriptionRow(label = "Weight", value = it.toString()) }
        pokemon.isDefault?.let {
            SingleValueDescriptionRow(
                label = "Is Default",
                value = it.toString()
            )
        }
        if (!pokemon.moves.isNullOrEmpty()) {
            MultipleValueDescriptionRow(label = "Moves", values = pokemon.moves)
        }
    }
}

@PreviewLightDark
@Composable
private fun PreviewDescriptionBlock(
    @PreviewParameter(PokemonPreviewParameterProvider::class) pokemon: PokemonPresentationModel
) {
    PokePokeTheme {
        DescriptionBlock(pokemon = pokemon)
    }
}
