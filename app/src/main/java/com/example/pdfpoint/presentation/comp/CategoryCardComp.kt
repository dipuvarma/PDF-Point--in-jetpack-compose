package com.example.pdfpoint.presentation.comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun CategoryCardComp(
    modifier: Modifier = Modifier,
    categoryName: String,
    categoryImage: String,
    onClick:()-> Unit
) {
    Column(
        modifier = modifier
            .width(150.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Replace with an actual image
        BookComp(
            cardWidth = 150.dp,
            cardHeight = 150.dp,
            image = categoryImage,
            onClick = {onClick.invoke()}
        )
        Spacer(Modifier.height(6.dp)) // Spacing between image and text
        // Category name
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.width(105.dp),
                text = categoryName,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis, // Ensure text doesn't overflow
            )
        }
    }
}
