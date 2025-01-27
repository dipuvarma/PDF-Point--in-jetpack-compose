package com.example.pdfpoint.presentation.comp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pdfpoint.ui.theme.PDFPointTheme

@Composable
fun CategoryCardComp(modifier: Modifier = Modifier) {

    var isLiked by remember { mutableStateOf(false) }
    var likesCount by remember { mutableIntStateOf(0) } // Example like count

    Column(
        modifier = modifier
            .padding(8.dp)
            .width(150.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Replace with an actual image
        BookComp(
            cardWidth = 150.dp,
            cardHeight = 200.dp,
            imageWidth = 100.dp,
            imageHeight = 150.dp
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
                    text = "Fairy Tales",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis, // Ensure text doesn't overflow
                )
                Text(
                    modifier = Modifier.width(105.dp),
                    text = "Hans Christian",
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


@Preview(showBackground = true)
@Composable
private fun PreComp() {
    PDFPointTheme {
        Surface {
            CategoryCardComp()
        }
    }
}
