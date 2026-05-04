package com.example.paisajes.uii


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.paisajes.data.Lugar
import com.example.paisajes.viewModel.MainViewModel

@Composable
fun PantallaLista(
    viewModel: MainViewModel,
    navController: NavController
) {
    val lugares by viewModel.lugares.collectAsState()

    Column {

        Button(onClick = {
            navController.popBackStack()
        }) {
            Text("← Volver al menú")
        }

        LazyColumn {
            items(lugares) { lugar ->
                ItemLugar(lugar)
            }
        }
    }
}

@Composable
fun ItemLugar(lugar: Lugar) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(8.dp)) {

            Image(
                painter = painterResource(id = lugar.imagen),
                contentDescription = lugar.nombre,
                modifier = Modifier.fillMaxWidth()
            )

            Text(lugar.nombre, style = MaterialTheme.typography.titleMedium)
            Text(lugar.descripcion)
        }
    }
}