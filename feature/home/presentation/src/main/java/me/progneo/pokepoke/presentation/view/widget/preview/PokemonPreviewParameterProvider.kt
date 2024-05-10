package me.progneo.pokepoke.presentation.view.widget.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import me.progneo.pokepoke.presentation.model.PokemonPresentationModel

class PokemonPreviewParameterProvider : PreviewParameterProvider<PokemonPresentationModel> {
    override val values = sequenceOf(
        PokemonPresentationModel(
            name = "clefairy",
            baseExperience = 113,
            height = 6,
            isDefault = true,
            order = 56,
            weight = 75,
            abilities = listOf("friend-guard"),
            forms = listOf("clefairy"),
            moves = listOf("pound"),
            sprites = listOf(
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/35.png",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/35.png",
                "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/35.png"
            ),
            species = "clefairy",
            stats = listOf(Pair("speed", "35")),
            types = listOf("fairy")
        )
    )
}
