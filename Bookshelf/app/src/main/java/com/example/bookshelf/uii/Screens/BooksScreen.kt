package com.example.bookshelf.uii.Screens

/*import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bookshelf.data.BookItem

@Composable
fun BooksScreen(books: List<BookItem>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(books) { book ->

            val image = book.volumeInfo.imageLinks?.thumbnail
                ?.replace("http://", "https://")

            Card(
                modifier = Modifier.padding(8.dp)
            ) {
                Column {

                    AsyncImage(
                        model = image,
                        contentDescription = book.volumeInfo.title?: "Sin título",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    )

                    Text(
                        text = book.volumeInfo.title?: "Sin título",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}*/

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.bookshelf.data.BookItem

@Composable
fun BooksScreen(books: List<BookItem>) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp)
    ) {

        items(books) { book ->

            val imageUrl =
                if (book.cover_i != null)
                    "https://covers.openlibrary.org/b/id/${book.cover_i}-M.jpg"
                else
                    null

            Card(
                modifier = Modifier.padding(8.dp)
            ) {

                Column {

                    AsyncImage(
                        model = imageUrl,
                        contentDescription = book.title,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                    )

                    Text(
                        text = book.title ?: "Sin título",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }
    }
}