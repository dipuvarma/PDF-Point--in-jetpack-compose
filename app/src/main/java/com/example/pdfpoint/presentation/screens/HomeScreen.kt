package com.example.pdfpoint.presentation.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pdfpoint.R
import com.example.pdfpoint.presentation.comp.CategoryCardComp
import com.example.pdfpoint.presentation.comp.HeadingText
import com.example.pdfpoint.presentation.comp.PopularCardComp
import com.example.pdfpoint.presentation.navigation.Graph.AllBookByCategory
import com.example.pdfpoint.presentation.navigation.Graph.Category
import com.example.pdfpoint.presentation.viewModel.AppViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    context: Context,
    navController: NavController,
    viewModel: AppViewModel,
) {

    /*Categories ui State*/
    val bookCategoriesState = viewModel.bookCategoryState.collectAsState()
    val categoriesList = bookCategoriesState.value.books ?: emptyList()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        item {
            HeadingText(
                title = context.getString(R.string.popular_books),
                subtitle = context.getString(R.string.show_all),
                onClick = { }
            )
            Spacer(Modifier.height(8.dp))
        }
        item {
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
            Spacer(Modifier.height(16.dp))
        }

        item {
            HeadingText(
                title = context.getString(R.string.categories),
                subtitle = context.getString(R.string.show_all),
                onClick = { navController.navigate(Category) }
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
                                    .fillMaxWidth(0.5f)
                            )
                        }
                    }
                }
            }
        }
    }
}
