package com.example.amphibians.uii

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.data.AmphibiansRepository
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import com.example.amphibians.network.AppContainer

class AmphibiansViewModel : ViewModel() {

    var uiState: AmphibiansUiState by mutableStateOf(AmphibiansUiState.Loading)
        private set

    init {
        getAmphibians()
    }

    private fun getAmphibians() {
        viewModelScope.launch {
            try {
                val result = AppContainer.amphibiansApiService.getAmphibians()
                println("DATOS: $result")
                uiState = AmphibiansUiState.Success(result)
            } catch (e: Exception) {
                e.printStackTrace()
                uiState = AmphibiansUiState.Error
            }
        }
    }
}