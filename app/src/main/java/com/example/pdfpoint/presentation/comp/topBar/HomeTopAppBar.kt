package com.example.pdfpoint.presentation.comp.topBar

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pdfpoint.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar(
    context: Context
) {
    TopAppBar(
        title = {
            Text(
                text = context.getString(R.string.app_name),
                color = MaterialTheme.colorScheme.onPrimaryContainer // Corrected contrast
            )
        },
        actions = {
            Icon(
                imageVector = Icons.Rounded.Person,
                contentDescription = "Profile Icon",
                modifier = Modifier.padding(end = 16.dp),
                tint = MaterialTheme.colorScheme.onPrimaryContainer // Corrected contrast
            )
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

