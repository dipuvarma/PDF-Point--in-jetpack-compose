package com.example.pdfpoint.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdfpoint.data.model.BookModel
import com.example.pdfpoint.data.repo.AppRepo
import com.example.pdfpoint.presentation.viewModel.state.BookCategoriesState
import com.example.pdfpoint.presentation.viewModel.state.BookState
import com.example.pdfpoint.presentation.viewModel.state.BooksByCategoryState
import com.example.pdfpoint.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val appRepo: AppRepo
) : ViewModel() {

    /*Books State*/
    private val _bookState = MutableStateFlow(BookState())
    val bookState = _bookState.asStateFlow()

    /*Categories State*/
    private val _bookCategoryState = MutableStateFlow(BookCategoriesState())
    val bookCategoryState = _bookCategoryState.asStateFlow()

    /*Books By Category State*/
    private val _bookByCategoryNameState = MutableStateFlow(BooksByCategoryState())
    val bookByCategoryState = _bookByCategoryNameState.asStateFlow()

    // Holds the current search query
    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery.asStateFlow()

    init {
        getAllBooks()
        getAllCategories()
    }


    // Combine books + search query to produce filtered list
    val filteredBooks: StateFlow<List<BookModel>> = combine(
        bookState,
        _searchQuery
    ) { state, query ->
        if (query.isBlank()) {
            state.books ?: emptyList()
        } else {
            state.books?.filter {
                it.bookName.contains(query, ignoreCase = true) ||
                        it.bookAuthor.contains(query, ignoreCase = true)
            } ?: emptyList()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Function to update search query
    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    /*Get All Books */
    fun getAllBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            appRepo.getAllBooks().collectLatest {
                _bookState.value = when (it) {
                    is Response.Loading -> BookState(isLoading = true)

                    is Response.Success -> BookState(books = it.data, isLoading = false)

                    is Response.Error -> BookState(
                        isLoading = false,
                        error = it.exception.localizedMessage ?: "Unknown error"
                    )

                }
            }
        }
    }

    /*Get Categories */
    fun getAllCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            appRepo.getAllCategories().collect {
                _bookCategoryState.value = when (it) {
                    is Response.Loading -> BookCategoriesState(isLoading = true)

                    is Response.Success -> BookCategoriesState(books = it.data, isLoading = false)

                    is Response.Error -> BookCategoriesState(
                        isLoading = false,
                        error = it.exception.localizedMessage ?: "Unknown error"
                    )

                }
            }
        }

    }

    /*Get All Books By categories name*/
    fun getAllBooksByCategoryName(categoryName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            appRepo.getAllBooksByCategoryName(categoryName).collectLatest {
                _bookByCategoryNameState.value = when (it) {
                    is Response.Loading -> BooksByCategoryState(isLoading = true)


                    is Response.Success -> BooksByCategoryState(books = it.data, isLoading = false)


                    is Response.Error -> BooksByCategoryState(
                        isLoading = false,
                        error = it.exception.localizedMessage ?: "Unknown Error"
                    )
                }
            }
        }
    }
}

