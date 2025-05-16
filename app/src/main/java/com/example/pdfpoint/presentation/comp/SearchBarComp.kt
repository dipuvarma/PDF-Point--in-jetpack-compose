package com.example.pdfpoint.presentation.comp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBarComp(
    query: TextFieldValue,
    onQueryChanged: (TextFieldValue) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    OutlinedTextField(
        value = query,
        onValueChange = onQueryChanged,
        placeholder = { Text("Search books") },
        label = { Text("Search") }, // 🛡️ Optional accessibility
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
            .padding(horizontal = 16.dp, vertical = 4.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = MaterialTheme.colorScheme.primary,
            unfocusedBorderColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
            disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.38f)
            // Other colors can be added if needed
        ),
        shape = MaterialTheme.shapes.medium,
        enabled = enabled,
        readOnly = !enabled,
        singleLine = true,
        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
        keyboardActions = KeyboardActions(
            onSearch = {
                onSearch()
                // optional: hide keyboard
            }
        )
    )
}
