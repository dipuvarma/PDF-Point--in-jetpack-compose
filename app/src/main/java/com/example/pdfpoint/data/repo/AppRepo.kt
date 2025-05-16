package com.example.pdfpoint.data.repo

import android.util.Log
import com.example.pdfpoint.data.model.BookCategoriesModel
import com.example.pdfpoint.data.model.BookModel
import com.example.pdfpoint.presentation.repo.AppRepoImpl
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

class AppRepo @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
) : AppRepoImpl {

    /*Get All Books*/
    override suspend fun getAllBooks(): Flow<Response<List<BookModel>>> = callbackFlow {
        trySend(Response.Loading)

        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = snapshot.children.mapNotNull {
                    it.getValue(BookModel::class.java)
                }
                trySend(Response.Success(items)).isSuccess
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("AppRepo", "getAllBooks: Error", error.toException())
                trySend(Response.Error(error.toException())).isSuccess
            }
        }

        val ref = firebaseDatabase.reference.child("books")
        ref.addValueEventListener(listener)

        awaitClose {
            ref.removeEventListener(listener)
        }
    }


    /*Get All Categories*/
    override suspend fun getAllCategories(): Flow<Response<List<BookCategoriesModel>>> =
        callbackFlow {

            trySend(Response.Loading)

            val listener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var items =
                        snapshot.children.mapNotNull { it.getValue(BookCategoriesModel::class.java) }

                    trySend(Response.Success(items)).isSuccess
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("AppRepo", "getAllCategories: Error", error.toException())
                    trySend(Response.Error(error.toException())).isSuccess
                }

            }
            val ref = firebaseDatabase.reference.child("categories")

            ref.addValueEventListener(listener)

            awaitClose {
                ref.removeEventListener(listener)
            }

        }


    /*Get All Books By Categories Name*/
    override suspend fun getAllBooksByCategoryName(categoryName: String): Flow<Response<List<BookModel>>> =
        callbackFlow {
            trySend(Response.Loading)

            val listener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    var items = snapshot.children.mapNotNull { it.getValue(BookModel::class.java) }
                        .filter { it.category == categoryName }

                    trySend(Response.Success(items)).isSuccess
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("AppRepo", "getAllBooksByCategoryName: Error", error.toException())

                    trySend(Response.Error(error.toException())).isSuccess
                }
            }

            val ref = firebaseDatabase.reference.child("books")

            ref.addValueEventListener(listener)

            awaitClose {
                ref.removeEventListener(listener)
            }
        }

}