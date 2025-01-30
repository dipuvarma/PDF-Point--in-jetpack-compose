package com.example.pdfpoint.presentation.screens

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdfpoint.R
import com.example.pdfpoint.presentation.comp.CategoryCardComp
import com.example.pdfpoint.presentation.comp.HeadingText
import com.example.pdfpoint.presentation.comp.PopularCardComp
import com.example.pdfpoint.presentation.navigation.AllBook
import com.example.pdfpoint.presentation.navigation.Category
import com.example.pdfpoint.ui.theme.PDFPointTheme

@Composable
fun HomeScreen(
    context: Context,
    navController: NavController
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp)
    ) {
        // Popular Books Section
        Column {
            HeadingText(
                title = context.getString(R.string.popular_books),
                subtitle = context.getString(R.string.show_all),
                onClick = {navController.navigate(AllBook.route) }
            )
            Spacer(Modifier.height(8.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                items(10) {
                    PopularCardComp(
                        bookName = "Fairy Tales",
                        authorName = "Author Name",
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }
        }

        Spacer(Modifier.height(16.dp))

        // Categories Section
        Column() {
            HeadingText(
                title = context.getString(R.string.categories),
                subtitle = context.getString(R.string.show_all),
                onClick = {navController.navigate(Category.route) }
            )
            Spacer(Modifier.height(8.dp))

            // Wrap LazyHorizontalGrid in a Box to constrain its height
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 200.dp, max = 400.dp) // Set min and max height constraints
            ) {
                LazyHorizontalGrid(
                    rows = GridCells.Fixed(3),
                    modifier = Modifier.fillMaxSize() // Fill the available height in the Box
                ) {
                    items(6) {
                        CategoryCardComp(
                            categoryImage = R.drawable.placeholder_news,
                            categoryName = "Category",
                            modifier = Modifier.padding(end = 16.dp, bottom = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreComp() {
    PDFPointTheme {
        Surface {

        }
    }
}