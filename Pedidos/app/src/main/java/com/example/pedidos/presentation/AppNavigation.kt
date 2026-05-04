package com.example.pedidos.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pedidos.presentation.product.create.CreateProductScreen
import com.example.pedidos.presentation.product.list.ListProductScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "product_list"
    ) {

        composable("product_list") {
            ListProductScreen()
        }

        composable("create_product") {
            CreateProductScreen(
                onNavigateBack = { navController.popBackStack() }
            )
        }
    }
}
