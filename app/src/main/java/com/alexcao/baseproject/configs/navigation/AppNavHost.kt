package com.alexcao.baseproject.configs.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alexcao.baseproject.presentation.screens.detail.DetailScreen
import com.alexcao.baseproject.presentation.screens.home.HomeScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    NavHost(navController = navController, NavigationItem.Home.route, modifier = modifier) {
        composable(NavigationItem.Home.route) {
            HomeScreen(
                navController = navController
            )
        }
        composable(NavigationItem.Detail.route) {
            DetailScreen(
                navController = navController
            )
        }
    }
}