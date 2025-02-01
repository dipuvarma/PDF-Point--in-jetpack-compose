package com.example.pdfpoint.data.repo

import com.example.pdfpoint.data.model.BookCategoriesModel
import com.example.pdfpoint.data.model.BookModel
import com.example.pdfpoint.presentation.viewModel.state.BookCategoriesState
import com.example.pdfpoint.utils.Response
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import com.google.firebase.database.getValue
import kotlinx.coroutines.channels.awaitClose

class AppRepo @Inject constructor(private val firebaseDatabase: FirebaseDatabase) {


    /*Get All Books*/
    suspend fun getAllBooks(): Flow<Response<List<BookModel>>> = callbackFlow {

        trySend(Response.Loading)

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var items: List<BookModel> = emptyList()
                items = snapshot.children.map {
                    it.getValue<BookModel>()!!
                }
                trySend(Response.Success(items))
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(Response.Error(error.toException()))
            }

        }
        firebaseDatabase.reference.child("books")
            .addValueEventListener(listener)

        awaitClose {
            firebaseDatabase.reference.child("books")
                .removeEventListener(listener)
        }

    }


    /*Get All Categories*/
    suspend fun getAllCategories(): Flow<Response<List<BookCategoriesModel>>> = callbackFlow {

        trySend(Response.Loading)

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var items: List<BookCategoriesModel> = emptyList()
                items = snapshot.children.map {
                    it.getValue<BookCategoriesModel>()!!
                }
                trySend(Response.Success(items))
            }

            override fun onCancelled(error: DatabaseError) {
                trySend(Response.Error(error.toException()))
            }

        }
        firebaseDatabase.reference.child("categories")
            .addValueEventListener(listener)

        awaitClose {
            firebaseDatabase.reference.child("categories")
                .removeEventListener(listener)
        }

    }


    /*Get All Books By Categories Name*/
    suspend fun getAllBooksByCategoryName(categoryName: String): Flow<Response<List<BookModel>>> =
        callbackFlow {
            trySend(Response.Loading)

            val listener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var items: List<BookModel> = emptyList()
                    items =
                        snapshot.children.filter { it.getValue<BookModel>()!!.category == categoryName }
                            .map {
                                it.getValue<BookModel>()!!
                            }
                    trySend(Response.Success(items))
                }

                override fun onCancelled(error: DatabaseError) {
                    trySend(Response.Error(error.toException()))
                }
            }

            firebaseDatabase.reference.child("books").addValueEventListener(listener)

            awaitClose {
                firebaseDatabase.reference.child("books")
                    .removeEventListener(listener)
            }
        }

}