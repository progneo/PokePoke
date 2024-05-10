package me.progneo.pokepoke.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import me.progneo.pokepoke.navigation.AppNavGraph
import me.progneo.pokepoke.presentation.theme.PokePokeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            PokePokeTheme {
                AppNavGraph(navController = navController)
            }
        }
    }
}
