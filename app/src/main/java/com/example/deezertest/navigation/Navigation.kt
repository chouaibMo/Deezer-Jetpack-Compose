package com.example.deezertest.navigation

import androidx.compose.animation.*
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.deezertest.presentation.artist.AlbumScreen
import com.example.deezertest.presentation.search.SearchScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

const val ARG_ARTIST_ID = "arg_artist_id"

internal sealed class Screen(val route: String) {
    object Search : Screen("search")
    object Artist : Screen("artist/{$ARG_ARTIST_ID}")

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(navController, startDestination = Screen.Search.route) {
        composable(route = Screen.Search.route) {
            SearchScreen(navController)
        }
        composable(
            route = Screen.Artist.route,
            arguments = listOf(
                navArgument(ARG_ARTIST_ID) { type = NavType.IntType },
            ),
        ) {
            AlbumScreen(navController)
        }
    }
}