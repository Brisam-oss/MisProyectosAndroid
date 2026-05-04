package com.example.bookshelf.data

import com.example.bookshelf.network.BooksApiService

/*class BooksRepository(
    private val apiService: BooksApiService
) {
    suspend fun getBooks(query: String): List<BookItem> {
        return apiService.getBooks(query).items ?: emptyList()
    }
}*/

class BooksRepository(
    private val apiService: BooksApiService
) {

    suspend fun getBooks(query: String): List<BookItem> {
        return apiService.getBooks(query).docs ?: emptyList()
    }
}