package com.example.catlogogeneral

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catlogogeneral.model.Libro

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LibroDetailScreen(
    libro: Libro,
    onBackToCatalog: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Detalle del Libro",
                        fontWeight = FontWeight.Bold
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackToCatalog) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Regresar"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(160.dp)
                    .background(Color(0xFFA5D6A7), shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.MenuBook,
                    contentDescription = null,
                    modifier = Modifier.size(90.dp),
                    tint = Color(0xFF004D40)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = libro.titulo,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            AtributoFila(icon = Icons.Default.Person, label = "Autor", value = libro.autor)
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), color = Color.LightGray)

            AtributoFila(icon = Icons.Default.CalendarToday, label = "Publicado", value = "${libro.anioPublicacion}")
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), color = Color.LightGray)

            AtributoFila(icon = Icons.Default.Bookmark, label = "Género", value = libro.genero)
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), color = Color.LightGray)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null,
                    tint = Color.Gray,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = "${libro.rating}★ (${libro.resenasCount} Reseñas)",
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp), color = Color.LightGray)

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Sinopsis",
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = libro.sinopsis,
                fontSize = 13.sp,
                color = Color.DarkGray,
                lineHeight = 18.sp,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            TextButton(onClick = { }) {
                Text(text = "Añadir a Favoritos", color = Color(0xFF1976D2))
            }
        }
    }
}

@Composable
private fun AtributoFila(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.size(20.dp)
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = "$label: ",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Text(
            text = value,
            fontSize = 14.sp,
            color = Color.DarkGray
        )
    }
}