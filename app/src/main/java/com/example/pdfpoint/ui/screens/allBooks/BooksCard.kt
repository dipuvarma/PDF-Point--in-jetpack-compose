package com.example.pdfpoint.ui.screens.allBooks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage


@Composable
fun BooksCard(
    imageUrl: String,
    bookName: String,
    bookAuthor: String,
    bookDescription: String,
    bookUrl: String,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(
                onClick = {
                    // Handle navigation or interaction
                }
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Card(
                modifier = Modifier
                    .size(120.dp) // Adjusted size for the image
                    .clip(RoundedCornerShape(8.dp)) // Adjusted corner shape
            ) {
//                Image(
//                    painter = painterResource(id = imageUrl),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop // Ensures the image fits the card nicely
//                )
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.width(16.dp)) // Space between image and text
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                Text(
                    text = bookName,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 18.sp, // Adjusted font size
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = bookAuthor,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray // Optional: Add subtle color to differentiate
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = bookDescription,
                    maxLines = 4, // Adjusted max lines
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.bodySmall.copy(
                        fontSize = 12.sp, // Adjusted font size for description
                        lineHeight = 16.sp
                    )
                )
            }
        }
    }
}

