package com.example.amphibians.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

private const val BASE_URL =
    "https://android-kotlin-fun-mars-server.appspot.com/"

object AppContainer {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(
            Json { ignoreUnknownKeys = true }
                .asConverterFactory("application/json".toMediaType())
        )
        .baseUrl(BASE_URL)
        .build()
    val amphibiansApiService: AmphibiansApiService =
        retrofit.create(AmphibiansApiService::class.java)
}