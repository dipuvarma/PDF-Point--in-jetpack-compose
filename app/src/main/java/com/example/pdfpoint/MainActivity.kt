package com.example.pdfpoint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.pdfpoint.ui.screens.allBooks.AllBookScreenUI
import com.example.pdfpoint.ui.screens.home.HomeScreenUI
import com.example.pdfpoint.ui.theme.PDFPointTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PDFPointTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AllBookScreenUI()
                }
            }
        }
    }
}
