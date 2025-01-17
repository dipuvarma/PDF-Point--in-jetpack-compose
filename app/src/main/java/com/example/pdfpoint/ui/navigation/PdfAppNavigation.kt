package com.example.pdfpoint.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pdfpoint.ui.screens.allBooks.AllBookScreenUI
import com.example.pdfpoint.ui.screens.home.HomeScreenUI

@Composable
fun PdfAppNavigation() {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = AllBookScreen) {
        composable<HomeScreen> {
            HomeScreenUI()
        }
        composable<AllBookScreen> {
            AllBookScreenUI()
        }
    }
}