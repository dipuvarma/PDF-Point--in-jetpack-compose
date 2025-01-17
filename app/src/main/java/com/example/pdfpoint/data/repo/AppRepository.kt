package com.example.pdfpoint.data.repo

import com.example.pdfpoint.data.model.BooksModel
import com.example.pdfpoint.util.ResponseState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class AppRepository @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
) {

    suspend fun getAllBooks(): Flow<ResponseState<List<BooksModel>>> = callbackFlow {
        trySend(ResponseState.Loading)

        val valueEvent = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var items: List<BooksModel> = emptyList()
                items = snapshot.children.map {
                    it.getValue<BooksModel>()!!
                }
                trySend(ResponseState.Success(items))
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(ResponseState.Error(error.toException()))
            }

        }

        firebaseDatabase.reference.child("Books").addValueEventListener(valueEvent)

        awaitClose {
            firebaseDatabase.reference.removeEventListener(valueEvent)
            close()
        }
    }
}