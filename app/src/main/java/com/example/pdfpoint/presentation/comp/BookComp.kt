package com.example.pdfpoint.presentation.comp

import android.widget.ImageView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.example.pdfpoint.R

@Composable
fun BookComp(
    modifier: Modifier = Modifier,
    cardWidth: Dp,
    cardHeight: Dp,
    image: String,
    onClick: () -> Unit = {}
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
                .padding(8.dp)
                .clickable { onClick.invoke() },
            shape = RoundedCornerShape(5.dp),
            shadowElevation = 2.dp
        ) {
            AndroidView(
                factory = { context ->
                    ImageView(context).apply {
                        scaleType = ImageView.ScaleType.CENTER_CROP // Set scale type to center crop
                        Glide.with(context)
                            .load(image)
                            .placeholder(R.drawable.placeholder_news)
                            .error(R.drawable.fairy_tales)
                            .centerCrop() // Apply center crop transformation
                            .into(this)
                    }
                }
            )
//            AsyncImage(
//                model = image,
//                contentDescription = null,
//                placeholder = painterResource(id = R.drawable.fairy_tales) ,
//                error = painterResource(id = R.drawable.fairy_tales),
//                contentScale = ContentScale.Crop,
//            )
        }
    }
}