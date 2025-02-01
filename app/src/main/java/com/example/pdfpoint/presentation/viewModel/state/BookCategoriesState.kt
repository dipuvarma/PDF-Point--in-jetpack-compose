package com.example.pdfpoint.presentation.viewModel.state

import com.example.pdfpoint.data.model.BookCategoriesModel

data class BookCategoriesState(
    val isLoading: Boolean = false,
    val books: List<BookCategoriesModel> = emptyList(),
    val error: String = ""
)