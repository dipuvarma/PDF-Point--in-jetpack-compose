package com.example.pdfpoint.presentation.screens

import android.content.Context
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
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
    navController: NavController,
    viewModel: AppViewModel,
) {

    /*Categories ui State*/
    val bookCategoriesState by viewModel.bookCategoryState.collectAsState()

    //All books State
    val bookState by viewModel.bookState.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {

        item {
            HeadingText(
                title = stringResource(id = R.string.popular_books),
                subtitle = stringResource(id = R.string.show_all),
                onClick = { }
            )
            Spacer(Modifier.height(8.dp))
        }

        item {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyRow(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(bookState.books) { book ->
                        PopularCardComp(
                            bookName = book.bookName,
                            authorName = book.bookAuthor,
                            modifier = Modifier.padding(end = 16.dp)
                        )
                    }
                }
                if (bookCategoriesState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                bookCategoriesState.error?.let { errorMsg ->
                    Text(
                        text = errorMsg,
                        color = Color.Red,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp)
                    )
                }
            }
            Spacer(Modifier.height(16.dp))
        }

        item {
            HeadingText(
                title = stringResource(id = R.string.categories),
                subtitle = stringResource(id = R.string.show_all),
                onClick = { navController.navigate(Category) }
            )
            Spacer(Modifier.height(8.dp))

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(bookCategoriesState.books) { category ->
                        CategoryCardComp(
                            categoryImage = category.categoryImage,
                            categoryName = category.categoryName,
                            onClick = { navController.navigate(AllBookByCategory(category.categoryName)) },
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                        )
                    }
                }

                if (bookCategoriesState.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }

                bookCategoriesState.error?.let { errorMsg ->
                    Text(
                        text = errorMsg,
                        color = Color.Red,
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}
