package com.example.pdfpoint.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.pdfpoint.ui.PdfAppViewModel
import org.koin.androidx.compose.koinViewModel
import kotlin.math.log


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenUI(
    viewModel: PdfAppViewModel = koinViewModel(),
) {

    val state = viewModel.getAllBookState.collectAsState()
    val data = state.value.books ?: emptyList()

    when {
        state.value.isLoading -> {
            Text(text = "Loading")
        }

        state.value.error.isNotEmpty() -> {
            Text(text = state.value.error)
        }

        else -> {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    Text(
                        text = "Books Categories",
                        style = TextStyle(
                            fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        )
                    )
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(top = 12.dp)
                    ) {
                        items(data) {
                            Text(text = it.BookName)
                            Text(text = it.BookAuthor)
                        }
                    }
                }
            }
        }

    }
}





