package com.example.pdfpoint.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.pdfpoint.presentation.comp.BookCardComp
import com.example.pdfpoint.presentation.comp.SearchBarComp
import com.example.pdfpoint.presentation.viewModel.AppViewModel

@Composable
fun AllBookScreen(
    viewModel: AppViewModel
) {

    /*All Books Data*/
    val data = viewModel.bookState.collectAsState()
    val booksListData = data.value.books


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)

    ) {
        SearchBarComp(
            query = TextFieldValue(""),
            onQueryChanged = { /* Handle query change */ },
            onSearch = { /* Handle search action */ }
        )
        Spacer(Modifier.height(8.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(booksListData) { book ->
                Log.d("TAG", "AllBookScreen: ${book.bookName}")
                BookCardComp(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    bookName = book.bookName,
                    authorName = book.bookAuthor,
                    bookImage = book.bookImage,
                    isBookmark = false,
                    onBookmarkClick = { /* Handle bookmark click */ },
                    onClickBook = { /* Handle book click */ }
                )
                HorizontalDivider()
            }
        }
    }
}