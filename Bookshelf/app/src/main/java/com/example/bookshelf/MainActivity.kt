package com.example.bookshelf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bookshelf.ui.*
import com.example.bookshelf.uii.Screens.BooksScreen
import androidx.compose.material3.*
import com.example.bookshelf.uii.BooksUiState
import com.example.bookshelf.uii.BooksViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: BooksViewModel = viewModel()

            when (val state = viewModel.uiState) {

                is BooksUiState.Loading -> {
                    Text("Cargando...")
                }

                is BooksUiState.Error -> {
                    Text("Error al cargar libros")
                }

                is BooksUiState.Success -> {
                    BooksScreen(state.books)
                }
            }
        }
    }
}