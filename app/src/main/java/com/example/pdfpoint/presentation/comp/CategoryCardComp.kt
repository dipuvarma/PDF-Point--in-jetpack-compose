package com.example.pdfpoint.presentation.comp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pdfpoint.R
import com.example.pdfpoint.ui.theme.PDFPointTheme

@Composable
fun CategoryCardComp(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .width(180.dp)
            .height(180.dp)
            .padding(8.dp), // Outer padding
        color = MaterialTheme.colorScheme.inversePrimary,
        shape = RoundedCornerShape(16.dp), // Unified corner radius for the whole card
       // shadowElevation = 2.dp // Optional: Add shadow for a card-like effect
    ) {
        Box {
            Column {
                // Image with rounded corners at the bottom end
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp), // Adjusted height for the image
                    shape = RoundedCornerShape(
                        bottomStart = 16.dp,
                        bottomEnd = 16.dp
                    ), // Bottom-end rounded corner
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.placeholder_news),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                    )
                }

                Text(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    text = "Category Name",
                    style = MaterialTheme.typography.titleMedium.copy(
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    ),
                )
            }
        }
    }
}


