package com.example.pdfpoint.presentation.screens

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pdfpoint.presentation.comp.bottomBar.BottomNavigationBar
import com.example.pdfpoint.presentation.comp.topBar.HomeTopAppBar
import com.example.pdfpoint.presentation.navigation.Graph
import com.example.pdfpoint.presentation.navigation.Graph.AllBook
import com.example.pdfpoint.presentation.navigation.Graph.Bookmark
import com.example.pdfpoint.presentation.navigation.Graph.Home
import com.example.pdfpoint.presentation.navigation.Graph.Profile
import com.example.pdfpoint.presentation.navigation.Graph.Search
import com.example.pdfpoint.presentation.viewModel.AppViewModel

@Composable
fun MainScreen(
    rootNavController: NavController,
    tabNavController: NavHostController,
    viewModel: AppViewModel
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            HomeTopAppBar()
        },
        bottomBar = {
            BottomNavigationBar(navController = tabNavController)
        }
    ) {
        NavHost(
            navController = tabNavController,
            startDestination = Home,
            modifier = Modifier.padding(it)
        ) {
            composable<Home> {
                HomeScreen(
                    navController = rootNavController,
                    viewModel = viewModel
                )
            }
            composable<AllBook> {
                AllBookScreen(
                    viewModel = viewModel,
                    navController = rootNavController
                )
            }
            composable<Search> {
                SearchScreen()
            }
            composable<Bookmark> {
                BookmarkScreen()
            }
            composable<Profile> {
                ProfileScreen()
            }
        }

    }
}