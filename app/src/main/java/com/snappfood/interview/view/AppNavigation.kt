package com.snappfood.interview.view

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.snappfood.interview.view.composable.SearchCharacterScreen
import com.snappfood.interview.viewmodel.CharacterDetailViewModel
import com.snappfood.interview.viewmodel.SearchCharacterViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "search") {
        composable("search") {
            val searchCharacterViewModel: SearchCharacterViewModel = hiltViewModel()

            SearchCharacterScreen(
                viewModel = searchCharacterViewModel,
                onCharacterSelected = { character ->
                    val encodedUrl =
                        URLEncoder.encode(character.url, StandardCharsets.UTF_8.toString())
                    navController.navigate("detail/$encodedUrl")
                }
            )
        }
        composable("detail/{characterUrl}") { backStackEntry ->
            val characterDetailViewModel: CharacterDetailViewModel = hiltViewModel()
            val characterUrl = backStackEntry.arguments?.getString("characterUrl") ?: ""
            CharacterDetailScreen(
                viewModel = characterDetailViewModel,
                characterUrl = characterUrl
            )
        }
    }
}