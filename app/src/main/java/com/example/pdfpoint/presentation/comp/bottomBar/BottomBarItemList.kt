package com.example.pdfpoint.presentation.comp.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Bookmark
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import com.example.pdfpoint.presentation.navigation.Graph.AllBook
import com.example.pdfpoint.presentation.navigation.Graph.Bookmark
import com.example.pdfpoint.presentation.navigation.Graph.Home
import com.example.pdfpoint.presentation.navigation.Graph.Profile

val bottomBarItemList = listOf(
    BottomBarItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        route = Home
    ),
    BottomBarItem(
        title = "All Books",
        selectedIcon = Icons.Filled.Book,
        unSelectedIcon = Icons.Outlined.Book,
        route = AllBook
    ),
    BottomBarItem(
        title = "Bookmark",
        selectedIcon = Icons.Filled.Bookmark,
        unSelectedIcon = Icons.Outlined.Bookmark,
        route = Bookmark
    ),
    BottomBarItem(
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
        route = Profile
    )
)