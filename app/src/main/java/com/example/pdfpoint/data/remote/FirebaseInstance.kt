package com.example.pdfpoint.data.remote

import com.google.firebase.database.FirebaseDatabase

object FirebaseInstance {

    fun provideFirebaseInstance(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }
}