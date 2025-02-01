package com.example.pdfpoint.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home {
    const val route = "home"
}

@Serializable
object AllBook {
    const val route = "all_book"
}

@Serializable
object Bookmark {
    const val route = "bookmark"
}

@Serializable
object Profile {
    const val route = "profile"
}

@Serializable
object Search {
    const val route = "search"
}

@Serializable
object EditProfile {
    const val route = "edit_profile"
}

@Serializable
object Category {
    const val route = "category"
}

@Serializable
data class AllBookByCategory(
    val categoryName: String
) {
    companion object {
        const val route = "all_book_by_category"
    }
}


@Serializable
data class PdfView(
    val bookUri: String
) {
    companion object {
        const val route = "pdf_view"
    }
}









