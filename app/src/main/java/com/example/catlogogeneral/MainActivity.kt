package com.example.catlogogeneral

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.catlogogeneral.model.Libro
import com.example.catlogogeneral.model.listaLibrosDummy

enum class Pantalla {
    HOME,
    CATALOGO,
    DETALLE
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    LibroApp()
                }
            }
        }
    }
}

@Composable
fun LibroApp() {
    var pantallaActual by remember { mutableStateOf(Pantalla.HOME) }
    var libroSeleccionado by remember { mutableStateOf<Libro?>(null) }

    when (pantallaActual) {
        Pantalla.HOME -> {
            LibroHomeScreen(
                onNavigateToCatalog = {
                    pantallaActual = Pantalla.CATALOGO
                }
            )
        }
        Pantalla.CATALOGO -> {
            LibroCatalogScreen(
                libros = listaLibrosDummy,
                onLibroSelect = { libro ->
                    libroSeleccionado = libro
                    pantallaActual = Pantalla.DETALLE
                },
                onBackToHome = {
                    pantallaActual = Pantalla.HOME
                }
            )
        }
        Pantalla.DETALLE -> {
            libroSeleccionado?.let { libro ->
                LibroDetailScreen(
                    libro = libro,
                    onBackToCatalog = {
                        pantallaActual = Pantalla.CATALOGO
                    }
                )
            }
        }
    }
}