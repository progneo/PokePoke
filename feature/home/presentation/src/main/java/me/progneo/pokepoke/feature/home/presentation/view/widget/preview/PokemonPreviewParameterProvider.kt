package me.progneo.pokepoke.feature.home.presentation.view.widget.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import me.progneo.pokepoke.feature.home.presentation.model.PokemonPresentationModel

internal class PokemonPreviewParameterProvider :
    PreviewParameterProvider<PokemonPresentationModel> {
    override val values = sequenceOf(
        PokemonPresentationModel(
            name = "clefairy",
            sprites = listOf(
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/35.png",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/35.png"
            )
        )
    )
}
