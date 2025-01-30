package com.example.pdfpoint.presentation.comp.bottomBar

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomBarItem <T : Any>(
    val title: String,
    val selectedIcon: ImageVector,
    val unSelectedIcon: ImageVector,
    val route: T
)

