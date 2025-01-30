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
import com.example.pdfpoint.presentation.navigation.AllBook
import com.example.pdfpoint.presentation.navigation.Bookmark
import com.example.pdfpoint.presentation.navigation.Home
import com.example.pdfpoint.presentation.navigation.Profile

val bottomBarItemList = listOf(
    BottomBarItem(
        title = "Home",
        selectedIcon = Icons.Filled.Home,
        unSelectedIcon = Icons.Outlined.Home,
        route = Home.route
    ),
    BottomBarItem(
        title = "All Books",
        selectedIcon = Icons.Filled.Book,
        unSelectedIcon = Icons.Outlined.Book,
        route = AllBook.route
    ),
    BottomBarItem(
        title = "Bookmark",
        selectedIcon = Icons.Filled.Bookmark,
        unSelectedIcon = Icons.Outlined.Bookmark,
        route = Bookmark.route
    ),
    BottomBarItem(
        title = "Profile",
        selectedIcon = Icons.Filled.Person,
        unSelectedIcon = Icons.Outlined.Person,
        route = Profile.route
    )
)