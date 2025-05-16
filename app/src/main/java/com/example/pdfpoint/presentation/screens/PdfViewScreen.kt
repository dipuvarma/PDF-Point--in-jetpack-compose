package com.example.pdfpoint.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Error
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pdfpoint.presentation.comp.topBar.TopAppBarComp
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.rememberVerticalPdfReaderState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PdfViewScreen(
    bookUri: String,
    navController: NavController,
    bookName: String,
) {
    val pdfState = rememberVerticalPdfReaderState(
        resource = ResourceType.Remote(bookUri),
        isZoomEnable = true
    )

    val isLoaded = pdfState.isLoaded
    val loadPercent = pdfState.loadPercent
    val error = pdfState.error

    val safeProgress = loadPercent.coerceIn(0, 100) / 100f

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            TopAppBarComp(
                title = bookName,
                navigationIcon = Icons.AutoMirrored.Filled.ArrowBack,
                onClickNavigationIcon = { navController.popBackStack() }
            )
            // PDF Viewer
            VerticalPDFReader(
                state = pdfState,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Show actual progress
        if (!isLoaded && error == null) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CircularProgressIndicator(
                    progress = safeProgress,
                    modifier = Modifier.size(100.dp),
                    strokeWidth = 4.dp,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "${loadPercent.coerceAtMost(100)}%",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground
                )
            }
        }

        // Show error
        error?.let { throwable ->
            Column(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(Icons.Default.Error, contentDescription = "Error", tint = Color.Red)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Failed to load PDF:\n${throwable.message}",
                    color = Color.Red,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
