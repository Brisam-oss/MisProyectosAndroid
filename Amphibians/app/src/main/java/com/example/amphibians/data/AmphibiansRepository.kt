package com.example.amphibians.data

import com.example.amphibians.network.AmphibiansApiService

class AmphibiansRepository(
    private val apiService: AmphibiansApiService
) {
    suspend fun getAmphibians(): List<Amphibian> {
        return apiService.getAmphibians()
    }
}