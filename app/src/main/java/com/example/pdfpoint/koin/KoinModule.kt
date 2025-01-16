package com.example.pdfpoint.koin

import com.example.pdfpoint.data.remote.FirebaseInstance
import com.example.pdfpoint.data.repo.AppRepository
import com.example.pdfpoint.ui.PdfAppViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { AppRepository(FirebaseInstance.provideFirebaseInstance()) }
}

val viewModelModule = module {
    viewModel { PdfAppViewModel(get()) }
}