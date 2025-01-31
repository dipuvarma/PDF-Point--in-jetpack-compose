package com.example.pdfpoint.presentation.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pdfpoint.presentation.comp.bottomBar.BottomNavigationBar
import com.example.pdfpoint.presentation.comp.topBar.HomeTopAppBar
import com.example.pdfpoint.presentation.comp.topBar.TitleWithNavTopBar
import com.example.pdfpoint.presentation.screens.AllBookByCategoryScreen
import com.example.pdfpoint.presentation.screens.AllBookScreen
import com.example.pdfpoint.presentation.screens.BookmarkScreen
import com.example.pdfpoint.presentation.screens.CategoryScreen
import com.example.pdfpoint.presentation.screens.EditProfileScreen
import com.example.pdfpoint.presentation.screens.HomeScreen
import com.example.pdfpoint.presentation.screens.PdfViewScreen
import com.example.pdfpoint.presentation.screens.ProfileScreen
import com.example.pdfpoint.presentation.screens.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfPointApp() {

    /*For local context*/
    val context = LocalContext.current

    /*For Navigation Controller*/
    val navController = rememberNavController()

    val currentBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry.value?.destination?.route

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            when (currentRoute) {
                Home.route -> HomeTopAppBar(context = context)
                else -> TitleWithNavTopBar(title = "Test UI", onBackClick = {})
            }
        },
        bottomBar = {
            when (currentRoute) {
                AllBookByCategory.route, PdfView.route, Category.route, EditProfile.route -> {
                    AnimatedVisibility(false) {
                        BottomNavigationBar(
                            navController = navController
                        )
                    }
                }
                else -> BottomNavigationBar(
                    navController = navController
                )
            }

        }

    ) { innerPadding ->

        NavHost(
            navController = navController,
            startDestination = Home.route,
            modifier = Modifier.padding(innerPadding),
        ) {
            composable(Home.route) {
                HomeScreen(
                    context = context,
                    navController = navController,
                    viewModel = hiltViewModel()
                )
            }
            composable(AllBook.route) {
                AllBookScreen(
                    viewModel = hiltViewModel()
                )
            }
            composable(Bookmark.route) {
                BookmarkScreen()
            }
            composable(Profile.route) {
                ProfileScreen()
            }
            composable(Search.route) {
                SearchScreen()
            }
            composable(EditProfile.route) {
                EditProfileScreen(context = context)
            }
            composable(Category.route) {
                CategoryScreen()
            }
            composable(AllBookByCategory.route) {
                AllBookByCategoryScreen()
            }
            composable(PdfView.route) {
                PdfViewScreen()
            }
        }
    }

}
