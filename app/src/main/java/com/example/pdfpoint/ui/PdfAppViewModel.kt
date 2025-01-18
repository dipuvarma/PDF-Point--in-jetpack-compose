package com.example.pdfpoint.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdfpoint.data.model.BookCategories
import com.example.pdfpoint.data.model.BooksModel
import com.example.pdfpoint.data.repo.AppRepository
import com.example.pdfpoint.util.ResponseState
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PdfAppViewModel @Inject constructor(
    private val appRepository: AppRepository,
) : ViewModel() {

    private val _getAllBookState = MutableStateFlow(GetAllBookState())
    val getAllBookState: StateFlow<GetAllBookState> = _getAllBookState.asStateFlow()

    private val _getAllCategoryState = MutableStateFlow(GetAllCategoryState())
    val getAllCategoryState = _getAllCategoryState.asStateFlow()

    private val _getBooksByCategoryState = MutableStateFlow(GetBooksByCategory())
    val getBooksByCategoryState = _getBooksByCategoryState.asStateFlow()


    fun getAllBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            appRepository.getAllBooks()
                .collect {
                    when (it) {
                        is ResponseState.Error -> {
                            _getAllBookState.value = GetAllBookState(
                                isLoading = false,
                                error = it.message.toString()
                            )
                        }

                        ResponseState.Loading -> {
                            _getAllBookState.value = GetAllBookState(
                                isLoading = true
                            )
                        }

                        is ResponseState.Success -> {
                            _getAllBookState.value = GetAllBookState(
                                isLoading = false,
                                books = it.data,
                            )
                        }
                    }
                }
        }
    }

    fun getAllCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            appRepository.getAllCategory().collect {
                when (it) {
                    is ResponseState.Error -> {
                        _getAllCategoryState.value = GetAllCategoryState(
                            isLoading = false,
                            error = it.message.toString()
                        )
                    }

                    is ResponseState.Loading -> {
                        _getAllCategoryState.value = GetAllCategoryState(
                            isLoading = true
                        )
                    }

                    is ResponseState.Success -> {
                        _getAllCategoryState.value = GetAllCategoryState(
                            isLoading = false,
                            books = it.data
                        )
                    }
                }
            }
        }
    }

    fun getBooksByCategory(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            appRepository.getBooksByCategory(category).collect {
                when (it) {
                    is ResponseState.Error -> {
                        _getBooksByCategoryState.value = GetBooksByCategory(
                            isLoading = false,
                            error = it.message.toString()
                        )
                    }

                    is ResponseState.Success -> {
                        _getBooksByCategoryState.value = GetBooksByCategory(
                            isLoading = false,
                            books = it.data
                        )

                    }

                    ResponseState.Loading -> {
                        _getBooksByCategoryState.value = GetBooksByCategory(
                            isLoading = true
                        )
                    }
                }
            }
        }
    }
}


data class GetAllBookState(
    val isLoading: Boolean = false,
    val books: List<BooksModel> = emptyList(),
    val error: String = "",
)

data class GetAllCategoryState(
    val isLoading: Boolean = false,
    val books: List<BookCategories> = emptyList(),
    val error: String = "",
)

data class GetBooksByCategory(
    val isLoading: Boolean = false,
    val books: List<BooksModel> = emptyList(),
    val error: String = "",
)