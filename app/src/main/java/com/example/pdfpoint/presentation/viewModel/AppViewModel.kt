package com.example.pdfpoint.presentation.viewModel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdfpoint.data.repo.AppRepo
import com.example.pdfpoint.presentation.viewModel.state.BookCategoriesState
import com.example.pdfpoint.presentation.viewModel.state.BookState
import com.example.pdfpoint.presentation.viewModel.state.BooksByCategoryModel
import com.example.pdfpoint.utils.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val appRepo: AppRepo) : ViewModel() {

    /*Books State*/
    private val _bookState = MutableStateFlow(BookState())
    val bookState = _bookState.asStateFlow()

    /*Categories State*/
    private val _bookCategoryState = MutableStateFlow(BookCategoriesState())
    val bookCategoryState = _bookCategoryState.asStateFlow()

    /*Books By Category State*/
    private val _bookByCategoryNameState = MutableStateFlow(BooksByCategoryModel())
    val bookByCategoryState = _bookByCategoryNameState.asStateFlow()

    init {
        getAllBooks()
        getAllCategories()
    }

    /*Get All Books */
    fun getAllBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            appRepo.getAllBooks().collect {
                when (it) {
                    is Response.Loading -> {
                        _bookState.value = BookState(isLoading = true)
                    }

                    is Response.Success -> {
                        _bookState.value = BookState(books = it.data, isLoading = false)
                    }

                    is Response.Error -> {
                        _bookState.value =
                            BookState(isLoading = false, error = it.exception.toString())
                    }
                }
            }
        }
    }

    /*Get Categories */
    fun getAllCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            appRepo.getAllCategories().collect {
                when (it) {
                    is Response.Loading -> {
                        _bookCategoryState.value = BookCategoriesState(isLoading = true)
                    }

                    is Response.Success -> {
                        _bookCategoryState.value =
                            BookCategoriesState(books = it.data, isLoading = false)
                    }

                    is Response.Error -> {
                        _bookCategoryState.value =
                            BookCategoriesState(isLoading = false, error = it.exception.toString())
                    }
                }
            }
        }

    }

    /*Get All Books By categories name*/
    fun getAllBooksByCategoryName(categoryName: String) {
        viewModelScope.launch(Dispatchers.IO) {
            appRepo.getAllBooksByCategoryName(categoryName).collect {
                when (it) {
                    is Response.Loading -> {
                        _bookByCategoryNameState.value = BooksByCategoryModel(isLoading = true)
                    }

                    is Response.Success -> {
                        _bookByCategoryNameState.value =
                            BooksByCategoryModel(books = it.data, isLoading = false)
                    }

                    is Response.Error -> {
                        _bookByCategoryNameState.value =
                            BooksByCategoryModel(isLoading = false, error = it.exception.toString())
                    }
                }
            }

        }
    }
}

