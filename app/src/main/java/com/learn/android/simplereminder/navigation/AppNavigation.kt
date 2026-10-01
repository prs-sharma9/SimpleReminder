package com.learn.android.simplereminder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learn.android.simplereminder.screens.HomeScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.HOME.name
    ) {
        composable (
            route = AppScreens.HOME.name
        ) {
            HomeScreen()
        }
    }
}