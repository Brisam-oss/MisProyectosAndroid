package com.example.bookshelf.network

/*import com.example.bookshelf.data.BookResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {

    @GET("volumes")
    suspend fun getBooks(
        @Query("q") query: String
    ): BookResponse
}*/

import com.example.bookshelf.data.BookResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface BooksApiService {

    @GET("search.json")
    suspend fun getBooks(
        @Query("q") query: String
    ): BookResponse
}