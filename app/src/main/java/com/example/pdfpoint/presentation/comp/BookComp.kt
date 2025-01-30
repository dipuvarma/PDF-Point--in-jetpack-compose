package com.example.pdfpoint.presentation.comp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BookComp(
    modifier: Modifier = Modifier,
    cardWidth: Dp,
    cardHeight: Dp,
    image:Int
) {
    Surface(
        modifier = modifier
            .size(
                width = cardWidth,
                height = cardHeight
            ),
        color = MaterialTheme.colorScheme.primaryContainer,
        shape = RoundedCornerShape(5.dp),
        ) {
        Surface(
            modifier = Modifier
                .padding(8.dp),
            shape = RoundedCornerShape(5.dp),
            shadowElevation = 2.dp
        ) {
            Image(
                painter = painterResource(id = image),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}
