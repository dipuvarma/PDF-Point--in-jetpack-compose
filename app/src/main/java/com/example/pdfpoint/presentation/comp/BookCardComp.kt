package com.example.pdfpoint.presentation.comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pdfpoint.ui.theme.PDFPointTheme

@Composable
fun BookCardComp(
    modifier: Modifier = Modifier,
    bookName: String,
    authorName: String,
    isBookmark: Boolean = false,
    onBookmarkClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Book thumbnail component
            BookComp(
                cardWidth = 80.dp, // Reduced size for better proportions
                cardHeight = 100.dp,
                imageWidth = 60.dp,
                imageHeight = 80.dp
            )
            Spacer(Modifier.width(12.dp)) // Refined spacing between thumbnail and text

            // Book details
            Column(
                verticalArrangement = Arrangement.Center,
                //modifier = Modifier.weight(1f) // Allow flexible space allocation for text
            ) {
                Text(
                    text = bookName,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.onBackground, // Better contrast
                        fontWeight = FontWeight.Bold // Subtle weight adjustment
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis // Ensure text doesn't overflow
                )
                Spacer(Modifier.height(2.dp)) // Add slight spacing between book name and author
                Text(
                    text = authorName,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.secondary.copy(alpha = 0.6f),
                        fontWeight = FontWeight.Normal// Softer color for author
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

        }
        // Bookmark icon
        IconButton(
            onClick = onBookmarkClick,
            modifier = Modifier.size(48.dp) // Slightly increased tap area for better UX
        ) {
            Icon(
                imageVector = if (isBookmark) Icons.Filled.Bookmark else Icons.Outlined.BookmarkBorder,
                contentDescription = "Bookmark",
                modifier = Modifier.size(28.dp), // Balanced size for the icon
                tint = MaterialTheme.colorScheme.primary // Unified with theme primary color
            )
        }
    }
}


