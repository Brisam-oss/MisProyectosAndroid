package com.example.amphibians.uii.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.amphibians.data.Amphibian

@Composable
fun HomeScreen(amphibians: List<Amphibian>) {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(amphibians) { amphibian ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(
                        text = "${amphibian.name} (${amphibian.type})",
                        style = MaterialTheme.typography.titleLarge
                    )

                    AsyncImage(
                        model = amphibian.imgSrc,
                        contentDescription = amphibian.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )

                    Text(text = amphibian.description)
                }
            }
        }
    }
}