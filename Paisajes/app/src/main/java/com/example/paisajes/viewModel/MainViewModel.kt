package com.example.paisajes.viewModel

import androidx.lifecycle.ViewModel
import com.example.paisajes.data.Lugar
import com.example.paisajes.data.LugaresRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _lugares = MutableStateFlow<List<Lugar>>(emptyList())
    val lugares: StateFlow<List<Lugar>> = _lugares

    fun cargarCategoria(categoria: String) {
        _lugares.value = when (categoria) {
            "cafeterias" -> LugaresRepository.cafeterias
            "restaurantes" -> LugaresRepository.restaurantes
            "parques" -> LugaresRepository.parques
            else -> emptyList()
        }
    }
}