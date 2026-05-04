package com.example.paisajes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.paisajes.navigation.AppNavigation
import com.example.paisajes.ui.theme.PaisajesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PaisajesTheme {
                AppNavigation()
            }
        }
    }
}