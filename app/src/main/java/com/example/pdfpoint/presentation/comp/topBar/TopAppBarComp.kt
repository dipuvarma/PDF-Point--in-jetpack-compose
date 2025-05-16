package com.example.pdfpoint.presentation.comp.topBar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarComp(
    title: String,
    navigationIcon: ImageVector? = null,
    actionIcon: ImageVector? = null,
    onClickNavigationIcon: (() -> Unit)? = null,
    onClickActionIcon: (() -> Unit)? = null,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    MaterialTheme.colorScheme.onPrimaryContainer
                ),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            if (navigationIcon != null && onClickNavigationIcon != null) {
                IconButton(onClick = onClickNavigationIcon) {
                    Icon(
                        imageVector = navigationIcon,
                        contentDescription = "Navigation icon",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        },
        actions = {
            if (actionIcon != null && onClickActionIcon != null) {
                IconButton(onClick = onClickActionIcon) {
                    Icon(
                        imageVector = actionIcon,
                        contentDescription = "Action icon",
                        tint = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        },

        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer, // Primary container background
            scrolledContainerColor = MaterialTheme.colorScheme.primaryContainer, // Subtle contrast on scroll
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer, // Ensures visibility
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer, // Text contrast
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer // Icon contrast
        ),
    )
}