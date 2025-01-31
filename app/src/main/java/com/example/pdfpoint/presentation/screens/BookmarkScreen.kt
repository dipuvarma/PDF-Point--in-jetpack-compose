package com.example.pdfpoint.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.pdfpoint.presentation.comp.BookCardComp
import com.example.pdfpoint.presentation.comp.SearchBarComp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookmarkScreen(
    modifier: Modifier = Modifier
) {
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
            items(5) {
                BookCardComp(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    bookName = "Book Name",
                    authorName = "Author Name",
                    isBookmark = true,
                    bookImage = "",
                    onClickBook = { /* Handle like click */ },
                    onBookmarkClick = { /* Handle bookmark click */ }
                )
                HorizontalDivider()
            }
        }
    }
}
