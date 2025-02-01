package com.example.pdfpoint.presentation.viewModel.state

import com.example.pdfpoint.data.model.BookModel

data class BooksByCategoryModel(
    val isLoading: Boolean = false,
    val books: List<BookModel> = emptyList(),
    val error: String = ""
)