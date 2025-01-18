package com.example.pdfpoint.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.pdfpoint.ui.screens.allBooks.AllBookScreenUI
import com.example.pdfpoint.ui.screens.bookBycategory.AllBooksByCategory
import com.example.pdfpoint.ui.screens.home.HomeScreenUI
import org.koin.androidx.compose.koinViewModel

@Composable
fun PdfAppNavigation() {
    var navController = rememberNavController()

    NavHost(navController = navController, startDestination = HomeScreen) {
        composable<HomeScreen> {
            HomeScreenUI(
                navController = navController,
                viewModel = koinViewModel()
            )
        }
        composable<AllBookScreen> {
            AllBookScreenUI()
        }
        composable<AllBooksByCategoryScreen>{
            val data = it.toRoute<AllBooksByCategoryScreen>()
            AllBooksByCategory(
                category = data.category,
                viewModel = koinViewModel()
            )
        }
    }
}