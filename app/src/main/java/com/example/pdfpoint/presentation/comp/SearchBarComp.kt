package com.example.pdfpoint.presentation.comp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarComp(
    query: TextFieldValue,
    onQueryChanged: (TextFieldValue) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true // Added to control if the search is enabled or not
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChanged,
        placeholder = { Text("Search books") },
        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon") },
        trailingIcon = {
            if (query.text.isNotEmpty()) {
                IconButton(onClick = { onQueryChanged(TextFieldValue("")) }) {
                    Icon(Icons.Filled.Clear, contentDescription = "Clear Search")
                }
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.primary, // Material 3 primary color
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f), // Material 3 color
           // textColor = MaterialTheme.colorScheme.onSurface, // Text color for input
            disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f), // Disabled text color
           // backgroundColor = MaterialTheme.colorScheme.surface, // Material 3 background color
            cursorColor = MaterialTheme.colorScheme.primary, // Cursor color when active
        ),
        shape = MaterialTheme.shapes.medium, // Material 3 shape
        enabled = enabled, // Control whether the text field is enabled
        readOnly = !enabled, // If disabled, set the TextField to read-only
        singleLine = true
    )
}