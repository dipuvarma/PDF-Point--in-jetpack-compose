package com.example.pdfpoint

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import com.example.pdfpoint.presentation.navigation.PdfPointApp
import com.example.pdfpoint.presentation.ui.theme.PDFPointTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PDFPointTheme(dynamicColor = false) {
                Surface() {
                    PdfPointApp()
                }
            }
        }
    }
}
