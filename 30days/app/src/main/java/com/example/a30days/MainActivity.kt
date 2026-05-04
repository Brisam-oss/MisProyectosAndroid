package com.example.a30days

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppRecetas()
        }
    }
}

data class Receta(
    val dia: String,
    val nombre: String,
    val ingredientes: String,
    val imagen: Int
)

val recetas = listOf(
    Receta("Día 1","Papas fritas", "Papas, aceite, sal", R.drawable.papas1),
    Receta("Día 2","Papas al horno", "Papas, romero, aceite", R.drawable.papas2),
    Receta("Día 3","Puré de papas", "Papas, leche, mantequilla", R.drawable.papas3),
    Receta("Día 4","Papas gratinadas", "Papas, queso, crema", R.drawable.papas4),
    Receta("Día 5","Papas bravas", "Papas, salsa picante, sal", R.drawable.papas5),
    Receta("Día 6","Tortitas de papa", "Papas, huevo, harina, sal", R.drawable.papas6),
    Receta("Día 7","Papas con jalapeño", "Papas, jalapeño, aceite, sal", R.drawable.papas7),
    Receta("Día 8","Papas enchipotladas", "Papas, chipotle, crema, sal", R.drawable.papas8),
    Receta("Día 9","Papas con chorizo y huevo", "Papas, chorizo, huevo, sal, aceite", R.drawable.papas9),
    Receta("Día 10","Papas a la mexicana", "Papas, jitomate, cebolla, chile", R.drawable.papas10),
    Receta("Día 11","Papas con rajas", "Papas, chile poblano, crema", R.drawable.papas11),
    Receta("Día 12","Papas con salchicha", "Papas, salchicha, aceite", R.drawable.papas12),
    Receta("Día 13","Papas con atún", "Papas, atún, mayonesa", R.drawable.papas13),
    Receta("Día 14","Papas con pollo", "Papas, pollo, sal, crema, leche", R.drawable.papas14),
    Receta("Día 15","Papas con epazote", "Papas, epazote, sal", R.drawable.papas15),
    Receta("Día 16","Torta de papa con queso y jamón", "Papas, queso, jamón, leche, maicena", R.drawable.papas16),
    Receta("Día 17","Papas con salsa chipotle", "Papas, chipotle, crema", R.drawable.papas17),
    Receta("Día 18","Papas con huevo", "Papas, huevo, sal", R.drawable.papas18),
    Receta("Día 19","Papas con tocino", "Papas, tocino, sal", R.drawable.papas19),
    Receta("Día 20","Papas al microondas", "Papas, sal, mantequilla", R.drawable.papas20),
    Receta("Día 21","Papas con champiñones y queso", "Papas, champiñones, crema, sal, ajo, queso", R.drawable.papas21),
    Receta("Día 22","Papas rancheras", "Papas, jitomate, chile", R.drawable.papas22),
    Receta("Día 23","Papas al ajo", "Papas, ajo, aceite", R.drawable.papas23),
    Receta("Día 24","Papas con cebolla", "Papas, cebolla, aceite", R.drawable.papas24),
    Receta("Día 25","Papas con espinaca", "Papas, espinaca, crema", R.drawable.papas25),
    Receta("Día 26","Crema de papa", "Papas, mantequilla, cebolla, crema, ajo", R.drawable.papas26),
    Receta("Día 27","Papas rellenas", "Papas, queso, jamón", R.drawable.papas27),
    Receta("Día 28","Papas con adobo", "Papas, adobo, ajo", R.drawable.papas28),
    Receta("Día 29","Papas con salsa de queso", "Papas, queso, leche", R.drawable.papas29),
    Receta("Día 30","Papas con nopales", "Papas, nopales, cebolla", R.drawable.papas30)
)

@Composable
fun AppRecetas() {
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "30 días haciendo papas",
                    style = MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center
                )
            }
        }

        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(recetas) { receta ->
                TarjetaReceta(receta)
            }
        }
    }
}

@Composable
fun TarjetaReceta(receta: Receta) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column {

            Image(
                painter = painterResource(id = receta.imagen),
                contentDescription = receta.nombre,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            Column(modifier = Modifier.padding(12.dp)) {

                Text(
                    text = receta.dia,
                    style = MaterialTheme.typography.labelLarge
                )

                Text(
                    text = receta.nombre,
                    style = MaterialTheme.typography.titleLarge
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = receta.ingredientes,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
