package com.example.pdfpoint.presentation.comp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.pdfpoint.R

@Composable
fun PopularCardComp(
    modifier: Modifier = Modifier,
    bookName: String,
    authorName: String,
) {

    var isLiked by remember { mutableStateOf(false) }
    var likesCount by remember { mutableIntStateOf(0) } // Example like count

    Column(
        modifier = modifier
            .width(150.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Replace with an actual image
        BookComp(
            cardWidth = 150.dp,
            cardHeight = 200.dp,
            image = "R.drawable.fairy_tales"
        )
        Spacer(Modifier.height(6.dp)) // Spacing between image and text
        // Category name
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    modifier = Modifier.width(105.dp),
                    text = bookName,
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis, // Ensure text doesn't overflow
                )
                Text(
                    modifier = Modifier.width(105.dp),
                    text = authorName,
                    style = MaterialTheme.typography.labelSmall.copy(
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f) // Softer secondary text color
                    ),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }

            IconButton(
                onClick = {
                    isLiked = !isLiked
                    likesCount += if (isLiked) 1 else -1
                }
            ) {
                Icon(
                    imageVector = if (isLiked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "Like Button",
                    tint = if (isLiked) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(
                        alpha = 0.6f
                    )
                )
            }
        }
    }
}



