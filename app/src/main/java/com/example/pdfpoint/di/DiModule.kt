package com.example.pdfpoint.di

import com.example.pdfpoint.data.repo.AppRepo
import com.google.firebase.Firebase
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DiModule {


    @Provides
    @Singleton
    fun getFirebaseRealTimeDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideRepo(firebaseDatabase: FirebaseDatabase): AppRepo {
        return AppRepo(firebaseDatabase)
    }

}