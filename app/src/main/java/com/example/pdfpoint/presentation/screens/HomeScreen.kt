package com.example.pdfpoint.presentation.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdfpoint.R
import com.example.pdfpoint.presentation.comp.CategoryCardComp
import com.example.pdfpoint.presentation.comp.HeadingText
import com.example.pdfpoint.presentation.comp.PopularCardComp
import com.example.pdfpoint.presentation.navigation.AllBook
import com.example.pdfpoint.presentation.navigation.AllBookByCategory
import com.example.pdfpoint.presentation.navigation.Category
import com.example.pdfpoint.presentation.viewModel.AppViewModel
import com.example.pdfpoint.presentation.viewModel.state.BookCategoriesState
import com.example.pdfpoint.ui.theme.PDFPointTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    context: Context,
    navController: NavController,
    viewModel: AppViewModel
) {

    /*Categories ui State*/
    val bookCategoriesState = viewModel.bookCategoryState.collectAsState()
    val categoriesList = bookCategoriesState.value.books ?: emptyList()


    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        // Popular Books Section
        Column {
            HeadingText(
                title = context.getString(R.string.popular_books),
                subtitle = context.getString(R.string.show_all),
                onClick = {  }
            )
            Spacer(Modifier.height(8.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth()
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
        Column {
            HeadingText(
                title = context.getString(R.string.categories),
                subtitle = context.getString(R.string.show_all),
                onClick = { navController.navigate(Category.route) }
            )
            Spacer(Modifier.height(8.dp))
            when {
                bookCategoriesState.value.isLoading -> {
                    Text(text = "Loading")
                }

                bookCategoriesState.value.error == null -> {
                    Text(text = "Error")
                }

                bookCategoriesState.value.books != null -> {
                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        items(categoriesList) { category ->
                            CategoryCardComp(
                                categoryImage = category.categoryImage,
                                categoryName = category.categoryName,
                                onClick = { navController.navigate(AllBookByCategory(category.categoryName)) },
                                modifier = Modifier
                                    .weight(1f)
                                    .fillMaxWidth(0.5f)
                            )
                        }
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