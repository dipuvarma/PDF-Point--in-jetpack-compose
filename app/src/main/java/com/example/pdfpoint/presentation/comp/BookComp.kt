package com.example.pdfpoint.presentation.comp

import android.widget.ImageView
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil3.compose.AsyncImage
import coil3.compose.AsyncImagePainter
import coil3.compose.rememberAsyncImagePainter
import com.bumptech.glide.Glide
import com.example.pdfpoint.R

@Composable
fun BookComp(
    modifier: Modifier = Modifier,
    cardWidth: Dp,
    cardHeight: Dp,
    image: String
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