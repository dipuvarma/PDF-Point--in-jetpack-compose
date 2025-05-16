package com.example.pdfpoint.presentation.repo

import com.example.pdfpoint.data.model.BookCategoriesModel
import com.example.pdfpoint.data.model.BookModel
import com.example.pdfpoint.utils.Response
import kotlinx.coroutines.flow.Flow

interface AppRepoImpl {

    suspend fun getAllBooks(): Flow<Response<List<BookModel>>>
    suspend fun getAllCategories(): Flow<Response<List<BookCategoriesModel>>>
    suspend fun getAllBooksByCategoryName(categoryName: String): Flow<Response<List<BookModel>>>
}