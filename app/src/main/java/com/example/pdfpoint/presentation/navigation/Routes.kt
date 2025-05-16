package com.example.pdfpoint.presentation.navigation

import kotlinx.serialization.Serializable


@Serializable
sealed class Graph {

    @Serializable
    object Main

    @Serializable
    object Home

    @Serializable
    object AllBook

    @Serializable
    object Bookmark

    @Serializable
    object Profile

    @Serializable
    object Search

    @Serializable
    object EditProfile

    @Serializable
    object Category

    @Serializable
    data class AllBookByCategory(
        val categoryName: String,
    )

    @Serializable
    data class PdfView(
        val bookUri: String,
    )
}











