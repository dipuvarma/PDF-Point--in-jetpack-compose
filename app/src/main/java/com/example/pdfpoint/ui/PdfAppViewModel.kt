package com.example.pdfpoint.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pdfpoint.data.model.BooksModel
import com.example.pdfpoint.data.repo.AppRepository
import com.example.pdfpoint.koin.viewModelModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
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

    fun getAllBooks(){
        viewModelScope.launch(Dispatchers.IO){
            appRepository.getAllBooks()
                .collect{
                    when(it){
                        is ResponseState.Error -> {
                            _getAllBookState.value = GetAllBookState(
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
                                books = it.data,
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