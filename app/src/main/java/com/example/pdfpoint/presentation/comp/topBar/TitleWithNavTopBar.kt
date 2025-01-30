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
                color = MaterialTheme.colorScheme.onPrimary // Title text color
            )
        },
        navigationIcon = {
            IconButton(onClick = { onBackClick.invoke() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onPrimary // Navigation icon color
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary, // AppBar background color
            scrolledContainerColor = MaterialTheme.colorScheme.primaryContainer, // Scrolled AppBar color
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary, // Navigation icon color
            titleContentColor = MaterialTheme.colorScheme.onPrimary // Title color
        ),
        modifier = modifier
    )
}
