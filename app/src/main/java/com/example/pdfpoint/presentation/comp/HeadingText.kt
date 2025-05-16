package com.example.pdfpoint.presentation.comp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HeadingText(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
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
            modifier = Modifier.clickable {
                onClick.invoke()
            },
            text = subtitle,
            style = MaterialTheme.typography.bodySmall.copy( // Adjust style for clarity
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f) // Slightly higher alpha for better contrast
            )
        )
    }
}


