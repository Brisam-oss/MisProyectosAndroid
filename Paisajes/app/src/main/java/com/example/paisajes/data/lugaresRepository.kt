package com.example.paisajes.data

import com.example.paisajes.R

object LugaresRepository {

    val cafeterias = listOf(
        Lugar("Café Brújula", "Café artesanal en Oaxaca", R.drawable.cafe1),
        Lugar("Café Nuevo Mundo", "Ambiente relajado", R.drawable.cafe2),
        Lugar("Café Punto Paz", "Café local acogedor", R.drawable.cafe3)
    )

    val restaurantes = listOf(
        Lugar("Casa Oaxaca", "Comida típica oaxaqueña", R.drawable.rest1),
        Lugar("Los Danzantes", "Alta cocina mexicana", R.drawable.rest2),
        Lugar("Itanoni", "Antojitos tradicionales", R.drawable.rest3)
    )

    val parques = listOf(
        Lugar("El Llano", "Parque tranquilo", R.drawable.parque1),
        Lugar("Jardín Etnobotánico", "Naturaleza y cultura", R.drawable.parque2),
        Lugar("Bosque El Tequio", "Área verde amplia", R.drawable.parque3)
    )
}