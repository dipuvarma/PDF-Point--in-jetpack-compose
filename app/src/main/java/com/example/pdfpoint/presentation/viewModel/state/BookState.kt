package com.example.pdfpoint.presentation.viewModel.state

import com.example.pdfpoint.data.model.BookCategoriesModel
import com.example.pdfpoint.data.model.BookModel

data class BookState(
    val isLoading: Boolean = false,
    val books: List<BookModel> = emptyList(),
    val error: String = ""
)

data class BookCategoriesState(
    val isLoading: Boolean = false,
    val books: List<BookCategoriesModel> = emptyList(),
    val error: String = ""
)
