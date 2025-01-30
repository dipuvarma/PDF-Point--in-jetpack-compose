package com.example.pdfpoint.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.pdfpoint.presentation.comp.BookCardComp
import com.example.pdfpoint.presentation.comp.SearchBarComp

@Composable
fun AllBookScreen(modifier: Modifier = Modifier) {
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
            items(20) {
                BookCardComp(
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
                    bookName = "Book Name",
                    authorName = "Author Name",
                    isBookmark = false,
                    onBookmarkClick = { /* Handle bookmark click */ }
                )
                HorizontalDivider()
            }
        }
    }
}