package me.progneo.pokepoke.presentation.view.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import me.progneo.pokepoke.detail.ui.content.SingleValueDescriptionRow
import me.progneo.pokepoke.presentation.model.PokemonPresentationModel
import me.progneo.pokepoke.presentation.view.widget.preview.PokemonPreviewParameterProvider

@Composable
fun DescriptionBlock(pokemon: PokemonPresentationModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        pokemon.baseExperience?.let {
            SingleValueDescriptionRow(label = "Base Experience", value = it.toString())
        }
        pokemon.height?.let { SingleValueDescriptionRow(label = "Height", value = it.toString()) }
        pokemon.isDefault?.let {
            SingleValueDescriptionRow(
                label = "Is Default",
                value = it.toString()
            )
        }
        pokemon.order?.let { SingleValueDescriptionRow(label = "Order", value = it.toString()) }
        pokemon.weight?.let { SingleValueDescriptionRow(label = "Weight", value = it.toString()) }
        pokemon.species?.let { SingleValueDescriptionRow(label = "Species", value = it) }
        if (!pokemon.abilities.isNullOrEmpty()) {
            MultipleValueDescriptionRow(label = "Abilities", values = pokemon.abilities)
        }
        if (!pokemon.forms.isNullOrEmpty()) {
            MultipleValueDescriptionRow(label = "Forms", values = pokemon.forms)
        }
        if (!pokemon.moves.isNullOrEmpty()) {
            MultipleValueDescriptionRow(label = "Moves", values = pokemon.moves)
        }
        if (!pokemon.types.isNullOrEmpty()) {
            MultipleValueDescriptionRow(label = "Types", values = pokemon.types)
        }
        if (!pokemon.stats.isNullOrEmpty()) {
            MultipleValueDescriptionRow(
                label = "Stats",
                values = pokemon.stats.map { "${it.first}: ${it.second}" }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewDescriptionBlock(
    @PreviewParameter(PokemonPreviewParameterProvider::class) pokemon: PokemonPresentationModel
) {
    MaterialTheme {
        DescriptionBlock(pokemon = pokemon)
    }
}
