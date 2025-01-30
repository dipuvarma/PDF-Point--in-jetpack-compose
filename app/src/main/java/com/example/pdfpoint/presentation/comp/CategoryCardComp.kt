package com.example.pdfpoint.presentation.comp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pdfpoint.R
import com.example.pdfpoint.presentation.screens.HomeScreen
import com.example.pdfpoint.ui.theme.PDFPointTheme

@Composable
fun CategoryCardComp(
    modifier: Modifier = Modifier,
    categoryName: String,
    categoryImage: Int
) {
    Surface(
        modifier = modifier.size(150.dp), // Size of the card
        shape = RoundedCornerShape(16.dp), // Rounded corners
        color = MaterialTheme.colorScheme.surface, // Background color from Material 3
        tonalElevation = 4.dp // Optional: Elevation for tonal effects
    ) {
        Box {
            // Image with rounded corners
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)), // Clip the image to match rounded corners
                painter = painterResource(id = categoryImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )

            // Semi-transparent overlay using Material color
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.6f)) // Semi-transparent overlay
            )

            // Centered text
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                text = categoryName,
                style = MaterialTheme.typography.titleMedium.copy(
                    color = MaterialTheme.colorScheme.onSurface, // Text color for contrast
                    fontWeight = FontWeight.Bold
                ),
                maxLines = 1, // Limit text to one line
                overflow = TextOverflow.Ellipsis // Truncate text if it's too long
            )
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreComp() {
    PDFPointTheme {
        Scaffold {
            CategoryCardComp(
                categoryName = "Category Name",
                categoryImage = R.drawable.placeholder_news,
                modifier = Modifier.padding(it)
            )
        }
    }
}
