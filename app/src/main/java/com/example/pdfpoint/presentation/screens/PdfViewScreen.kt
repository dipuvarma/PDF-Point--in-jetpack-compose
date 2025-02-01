package com.example.pdfpoint.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rizzi.bouquet.PdfReaderState
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.dp
import com.rizzi.bouquet.rememberVerticalPdfReaderState
import kotlinx.coroutines.delay

@Composable
fun PdfViewScreen(
    bookUri: String
) {
    val pdfState = rememberVerticalPdfReaderState(
        resource = ResourceType.Remote(bookUri),
        isZoomEnable = true
    )

    // State to track loading progress
    var loadingProgress by remember { mutableStateOf(0f) }
    var isLoading by remember { mutableStateOf(true) }

    // Simulate loading progress
    LaunchedEffect(Unit) {
        for (i in 0..100) {
            delay(60) // Simulate progress (adjust delay as needed)
            loadingProgress = i / 100f
        }
        isLoading = false // Loading complete
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {

       VerticalPDFReader(
            state = pdfState,
            modifier = Modifier.fillMaxSize()
        )

        // Show loading indicator while loading
        if (isLoading) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Circular progress bar with percentage
                CircularProgressIndicator(
                    progress = loadingProgress,
                    modifier = Modifier.size(100.dp()),
                    strokeWidth = 8.dp(),
                    color = MaterialTheme.colorScheme.primary, // Use primary color
                )
                Spacer(modifier = Modifier.height(16.dp()))
                // Display percentage text
                Text(
                    text = "${(loadingProgress * 100).toInt()}%",
                    color = MaterialTheme.colorScheme.onBackground, // Use onBackground color
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}