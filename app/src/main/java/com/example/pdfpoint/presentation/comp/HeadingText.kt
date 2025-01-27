package com.example.pdfpoint.presentation.comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pdfpoint.ui.theme.PDFPointTheme

@Composable
fun HeadingText(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp), // Add padding for spacing
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge.copy( // Use a larger size for prominence
                color = MaterialTheme.colorScheme.primary
            )
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.bodySmall.copy( // Adjust style for clarity
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f) // Slightly higher alpha for better contrast
            )
        )
    }
}


