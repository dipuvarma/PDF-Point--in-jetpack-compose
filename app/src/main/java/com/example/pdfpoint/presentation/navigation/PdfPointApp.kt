package com.example.pdfpoint.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pdfpoint.presentation.screens.AllBookByCategoryScreen
import com.example.pdfpoint.presentation.screens.AllBookScreen
import com.example.pdfpoint.presentation.screens.BookmarkScreen
import com.example.pdfpoint.presentation.screens.CategoryScreen
import com.example.pdfpoint.presentation.screens.EditProfileScreen
import com.example.pdfpoint.presentation.screens.HomeScreen
import com.example.pdfpoint.presentation.screens.PdfViewScreen
import com.example.pdfpoint.presentation.screens.ProfileScreen
import com.example.pdfpoint.presentation.screens.SearchScreen

@Composable
fun PdfPointApp() {

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = Home,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Home> {
                HomeScreen()
            }
            composable<AllBook> {
                AllBookScreen()
            }
            composable<Bookmark> {
                BookmarkScreen()
            }
            composable<Profile> {
                ProfileScreen()
            }
            composable<Search> {
                SearchScreen()
            }
            composable<EditProfile> {
                EditProfileScreen()
            }
            composable<Category> {
                CategoryScreen()
            }
            composable<AllBookByCategory> {
                AllBookByCategoryScreen()
            }
            composable<PdfView> {
                PdfViewScreen()
            }
        }
    }

}
