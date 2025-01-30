package com.example.pdfpoint.presentation.comp.topBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TitleWithNavTopBar(
    modifier: Modifier = Modifier,
    title: String,
    onBackClick: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = MaterialTheme.colorScheme.onPrimaryContainer // Corrected for contrast
            )
        },
        navigationIcon = {
            IconButton(onClick = { onBackClick.invoke() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer // Ensures visibility
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer, // AppBar background color
            scrolledContainerColor = MaterialTheme.colorScheme.primaryContainer, // Scrolled AppBar color
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer, // Icon color on primaryContainer
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer, // Title color on primaryContainer
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer // Action icon color on primaryContainer
        ),
        modifier = modifier
    )
}


