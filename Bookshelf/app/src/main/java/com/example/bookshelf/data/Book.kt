package com.example.bookshelf.data

/*data class BookResponse(
    val items: List<BookItem>?
)*/

data class BookResponse(
    val docs: List<BookItem>?
)

/*data class BookItem(
    val id: String,
    val volumeInfo: VolumeInfo
)*/

data class BookItem(
    val key: String,
    val title: String?,
    val cover_i: Int?
)

data class VolumeInfo(
    val title: String?,
    val imageLinks: ImageLinks?
)

data class ImageLinks(
    val thumbnail: String
)