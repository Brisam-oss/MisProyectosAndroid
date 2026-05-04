package com.example.paisajes.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import androidx.navigation.compose.*
import androidx.navigationevent.compose.*
import com.example.paisajes.uii.PantallaHome
import com.example.paisajes.uii.PantallaLista
import com.example.paisajes.viewModel.MainViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val viewModel: MainViewModel = viewModel()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            PantallaHome(navController)
        }

        composable("cafeterias") {
            viewModel.cargarCategoria("cafeterias")
            PantallaLista(viewModel, navController)
        }

        composable("restaurantes") {
            viewModel.cargarCategoria("restaurantes")
            PantallaLista(viewModel, navController)
        }

        composable("parques") {
            viewModel.cargarCategoria("parques")
            PantallaLista(viewModel, navController)
        }
    }
}