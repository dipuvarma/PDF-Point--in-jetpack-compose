package com.example.pdfpoint.presentation.screens

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pdfpoint.R

@SuppressLint("UnrememberedMutableState")
@Composable
fun EditProfileScreen(
) {

    val context = LocalContext.current

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var bio by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    var isSaveAttempted by remember { mutableStateOf(false) }

    val isNameValid by derivedStateOf {
        name.matches(Regex("^[a-zA-Z]+( [a-zA-Z]+)*$")) && name.length in 4..20
    }

    val isEmailValid by derivedStateOf {
        email.isNotBlank() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    val isBioValid by derivedStateOf {
        bio.matches(Regex("^[a-zA-Z0-9.,!? ]*$")) && bio.length in 10..50
    }

    val isGenderValid by derivedStateOf {
        gender.isNotBlank()
    }

    val isFormValid by derivedStateOf {
        isNameValid && isEmailValid && isBioValid && isGenderValid
    }

    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.edit_title),
            style = MaterialTheme.typography.titleLarge.copy(
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = stringResource(id = R.string.edit_des),
            style = MaterialTheme.typography.labelSmall.copy(
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center, // Center the text horizontally
            ),
        )
        Spacer(modifier = Modifier.height(24.dp))
        Surface(
            modifier = Modifier
                .size(120.dp),
            shape = CircleShape,
            color = MaterialTheme.colorScheme.surface,
            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary)
        ) {
            AsyncImage(
                model = R.drawable.placeholder_news,
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            isError = isSaveAttempted && !isNameValid, // Show error only on save attempt
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            supportingText = {
                if (isSaveAttempted && !isNameValid) {
                    Text("Name must be 4-20 characters and contain only letters and spaces.")
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            isError = isSaveAttempted && !isEmailValid,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            supportingText = {
                if (isSaveAttempted && !isEmailValid) {
                    Text("Please enter a valid email address.")
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(onNext = { focusManager.moveFocus(FocusDirection.Down) })
        )

        OutlinedTextField(
            value = bio,
            onValueChange = { bio = it },
            label = { Text("Bio") },
            isError = isSaveAttempted && !isBioValid,
            modifier = Modifier.fillMaxWidth(),
            supportingText = {
                if (isSaveAttempted && !isBioValid) {
                    Text("Bio must be between 10 and 50 characters.")
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        )

        Text(
            text = "Select Gender",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.align(Alignment.Start)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            RadioButton(selected = gender == "Male", onClick = { gender = "Male" })
            Text(
                "Male",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(end = 16.dp)
            )
            RadioButton(selected = gender == "Female", onClick = { gender = "Female" })
            Text("Female", style = MaterialTheme.typography.bodyMedium)
        }
        if (isSaveAttempted && !isGenderValid) {
            Text(
                "Please select a gender",
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.align(Alignment.Start)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(
            onClick = {
                isSaveAttempted = true
                if (isFormValid) {
                    Toast.makeText(context, "Profile Saved!", Toast.LENGTH_SHORT).show()
                    isSaveAttempted = false
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
        ) {
            Text("Save Profile")
        }
    }
}
