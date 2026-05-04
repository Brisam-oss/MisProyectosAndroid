package com.example.bookshelf.uii

import androidx.lifecycle.ViewModel
import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import com.example.bookshelf.data.BooksRepository
import com.example.bookshelf.network.AppContainer

class BooksViewModel : ViewModel() {

    private val repository =
        BooksRepository(AppContainer.booksApiService)

    var uiState: BooksUiState by mutableStateOf(BooksUiState.Loading)
        private set

    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch {
            try {
                val books = repository.getBooks("harry potter")
                uiState = BooksUiState.Success(books)
            } catch (e: Exception) {
                e.printStackTrace()
               //println("ERROR REAL: ${e.message}")
                android.util.Log.e("BooksError", "Error", e)
                uiState = BooksUiState.Error
            }
        }
    }
}