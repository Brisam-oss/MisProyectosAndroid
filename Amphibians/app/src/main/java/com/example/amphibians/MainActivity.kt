package com.example.amphibians

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibians.uii.AmphibiansViewModel
import com.example.amphibians.uii.AmphibiansUiState
import com.example.amphibians.uii.screens.HomeScreen
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val viewModel: AmphibiansViewModel = viewModel()

            AmphibiansApp(viewModel)
        }
    }
}

@Composable
fun AmphibiansApp(viewModel: AmphibiansViewModel) {
    when (val state = viewModel.uiState) {

        is AmphibiansUiState.Loading -> {
            Text("Cargando...")
        }

        is AmphibiansUiState.Error -> {
            Text("Error al cargar datos")
        }

        is AmphibiansUiState.Success -> {
            HomeScreen(amphibians = state.amphibians)
        }
    }
}