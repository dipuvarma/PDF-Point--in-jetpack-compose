package com.example.pdfpoint.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdfpoint.presentation.comp.BookCardComp
import com.example.pdfpoint.presentation.comp.SearchBarComp
import com.example.pdfpoint.presentation.navigation.Graph.PdfView
import com.example.pdfpoint.presentation.viewModel.AppViewModel

@Composable
fun AllBookScreen(
    viewModel: AppViewModel,
    navController: NavController,
) {
    val query by viewModel.searchQuery.collectAsState()
    val filteredBooks by viewModel.filteredBooks.collectAsState()
    val state by viewModel.bookState.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // 🔍 Search bar
            SearchBarComp(
                query = TextFieldValue(query),
                onQueryChanged = { viewModel.updateSearchQuery(it.text) },
                onSearch = { /* optional: hide keyboard */ }
            )

            Spacer(modifier = Modifier.height(8.dp))

            // 📚 Book list
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(filteredBooks) { book ->
                    BookCardComp(
                        modifier = Modifier.padding(vertical = 8.dp),
                        bookName = book.bookName,
                        authorName = book.bookAuthor,
                        bookImage = book.bookImage,
                        isBookmark = false,
                        onBookmarkClick = { /* Handle */ },
                        onClickBook = {
                            navController.navigate("pdf_view/${book.bookUrl}")
                        }
                    )
                    HorizontalDivider()
                }
            }
        }

        // ⏳ Loading state overlay
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }

        // ❗ Error overlay
        state.error?.let { error ->
            Text(
                text = error,
                modifier = Modifier.align(Alignment.Center),
                color = Color.Red
            )
        }
    }
}

//@Composable
//fun AllBookScreen(
//    viewModel: AppViewModel,
//    navController: NavController
//) {
//    // Collect the book state from the ViewModel
//    val state = viewModel.bookState.collectAsState()
//
//    // Extract the books list from the state, defaulting to an empty list if null
//    val booksListData = state.value.books ?: emptyList()
//
//    // Handle different states (loading, error, success)
//    when {
//        state.value.isLoading -> {
//            // Show loading indicator
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .wrapContentSize(Alignment.Center)
//            ) {
//                Text(text = "Loading...")
//            }
//        }
//
//        state.value.error == null -> {
//            // Show error message
//            Box(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .wrapContentSize(Alignment.Center)
//            ) {
//                Text(text = "Error: ${state.value.error}")
//            }
//        }
//
//        else -> {
//            // Show the list of books
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(top = 8.dp, start = 16.dp, end = 16.dp)
//            ) {
//                // Search bar component
//                SearchBarComp(
//                    query = TextFieldValue(""),
//                    onQueryChanged = { /* Handle query change */ },
//                    onSearch = { /* Handle search action */ }
//                )
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                // LazyColumn to display the list of books
//                LazyColumn(
//                    modifier = Modifier.fillMaxSize()
//                ) {
//                    items(booksListData) { book ->
//                        // Book card component
//                        BookCardComp(
//                            modifier = Modifier.padding(vertical = 8.dp),
//                            bookName = book.bookName,
//                            authorName = book.bookAuthor,
//                            bookImage = book.bookImage,
//                            isBookmark = false,
//                            onBookmarkClick = { /* Handle bookmark click */ },
//                            onClickBook = { navController.navigate(PdfView(bookUri = book.bookUrl)) }
//                        )
//                        // Horizontal divider between books
//                        HorizontalDivider()
//                    }
//                }
//            }
//        }
//    }
//}