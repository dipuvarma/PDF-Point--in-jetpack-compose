package com.example.pdfpoint.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenUI() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),
//        topBar = {
//            SearchBar(
//                query = "",
//                onQueryChange = {},
//                onSearch = {},
//                active = TODO(),
//                onActiveChange = TODO(),
//                placeholder = { Text(text = "Search Books") },
//                leadingIcon = {
//                    Image(
//                        imageVector = Icons.Default.Search,
//                        contentDescription = "Search"
//                    )
//                },
//                shape = RoundedCornerShape(2.dp),
//                content = TODO(),
//            )
//        }
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
        }
    }
}