package com.example.pdfpoint.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdfpoint.presentation.comp.BookCardComp
import com.example.pdfpoint.presentation.navigation.Graph.PdfView
import com.example.pdfpoint.presentation.viewModel.AppViewModel

@Composable
fun AllBookByCategoryScreen(
    viewModel: AppViewModel,
    navController: NavController,
    categoryName: String
) {

    val state = viewModel.bookByCategoryState.collectAsState()
    val allBooksByCatList = state.value.books ?: emptyList()

    LaunchedEffect(Unit) {
        viewModel.getAllBooksByCategoryName(categoryName)
    }

    when {
        state.value.isLoading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {

                CircularProgressIndicator()
            }
        }

        state.value.error == null -> {
            Text(text = "Error: ${state.value.error}")
        }

        else -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            ) {
                Text(
                    text = categoryName,
                    style = MaterialTheme.typography.titleLarge.copy( // Use a larger size for prominence
                        color = MaterialTheme.colorScheme.primary
                    )
                )
                Spacer(Modifier.height(8.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(allBooksByCatList) { book ->
                        BookCardComp(
                            modifier = Modifier.padding(vertical = 8.dp),
                            bookName = book.bookName,
                            authorName = book.bookAuthor,
                            bookImage = book.bookImage,
                            onBookmarkClick = { },
                            onClickBook = { navController.navigate(PdfView(bookUri = book.bookUrl)) }
                        )
                        HorizontalDivider()
                    }
                }
            }
        }
    }

}