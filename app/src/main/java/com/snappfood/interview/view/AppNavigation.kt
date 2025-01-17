package com.snappfood.interview.view

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.snappfood.interview.view.composable.SearchScreen
import com.snappfood.interview.viewmodel.CharacterViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "search") {
        composable("search") {
            val viewModel: CharacterViewModel = hiltViewModel()

            SearchScreen(
                viewModel = viewModel,
                onCharacterSelected = { character ->
                    navController.navigate("details/${character}")
                }
            )
        }
    }
}