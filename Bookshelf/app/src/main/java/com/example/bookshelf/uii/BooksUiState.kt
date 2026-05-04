package com.example.bookshelf.uii

import com.example.bookshelf.data.BookItem

sealed interface BooksUiState {
    object Loading : BooksUiState
    object Error : BooksUiState
    data class Success(val books: List<BookItem>) : BooksUiState
}