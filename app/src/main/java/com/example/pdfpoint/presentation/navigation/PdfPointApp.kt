package com.example.pdfpoint.presentation.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.pdfpoint.presentation.navigation.Graph.AllBookByCategory
import com.example.pdfpoint.presentation.navigation.Graph.Category
import com.example.pdfpoint.presentation.navigation.Graph.Main
import com.example.pdfpoint.presentation.navigation.Graph.PdfView
import com.example.pdfpoint.presentation.screens.AllBookByCategoryScreen
import com.example.pdfpoint.presentation.screens.CategoryScreen
import com.example.pdfpoint.presentation.screens.MainScreen
import com.example.pdfpoint.presentation.screens.PdfViewScreen
import com.example.pdfpoint.presentation.viewModel.AppViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfPointApp() {

    /*For Navigation Controller*/
    val rootNavController = rememberNavController()
    val tabNavController = rememberNavController()

    //for viewModel
    val viewModel = hiltViewModel<AppViewModel>()

    NavHost(
        navController = rootNavController,
        startDestination = Main,
    ) {

        composable<Main> {
            MainScreen(
                rootNavController = rootNavController,
                tabNavController = tabNavController,
                viewModel = viewModel
            )
        }

        composable<Category> {
            CategoryScreen(
                viewModel = viewModel,
                navController = rootNavController
            )
        }
        composable<AllBookByCategory> {
            val categoryName = it.toRoute<AllBookByCategory>()
            AllBookByCategoryScreen(
                viewModel = viewModel,
                navController = rootNavController,
                categoryName = categoryName.categoryName
            )
        }
        composable<PdfView> {
            val book = it.toRoute<PdfView>()
            PdfViewScreen(
                bookUri = book.bookUri,
                navController = rootNavController,
                bookName = book.bookTitle
            )
        }
    }
}
