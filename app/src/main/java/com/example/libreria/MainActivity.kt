package com.example.libreria

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.libreria.datos.DatosLibreria
import com.example.libreria.modelo.Autor
import com.example.libreria.modelo.Libro

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { LibreriaApp() }
    }
}

@Composable
fun LibreriaApp() {
    var mostrarAutores by rememberSaveable { mutableStateOf(false) }
    BackHandler(enabled = mostrarAutores) { mostrarAutores = false }
    MaterialTheme(colorScheme = lightColorScheme(
        primary = Color(0xFF28594B),
        background = Color(0xFFF7F6F0),
        surface = Color(0xFFFFFFFF)
    )) {
        Scaffold { espacio ->
            Column(Modifier.fillMaxSize().padding(espacio).padding(20.dp)) {
                Text("Mi librería", style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary)
                Text("Historias para descubrir", style = MaterialTheme.typography.bodyMedium)
                Spacer(Modifier.height(20.dp))
                if (mostrarAutores) {
                    PantallaAutores(DatosLibreria.autores) { mostrarAutores = false }
                } else {
                    PantallaLibros(DatosLibreria.libros) { mostrarAutores = true }
                }
            }
        }
    }
}

@Composable
fun PantallaLibros(libros: List<Libro>, verAutores: () -> Unit) {
    Column(Modifier.fillMaxSize()) {
        Text("Catálogo de libros", style = MaterialTheme.typography.headlineSmall)
        Text("${libros.size} libros", style = MaterialTheme.typography.bodyMedium)
        Button(onClick = verAutores, modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)) {
            Text("Ver autores")
        }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.weight(1f)) {
            items(libros, key = { it.id }) { libro ->
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(libro.obtenerDetalle(), style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold)
                        Text(libro.obtenerPrecioFormateado(), color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.titleLarge)
                        Text(if (libro.estaDisponible()) "Disponible: ${libro.stock} unidades" else "Agotado")
                    }
                }
            }
        }
    }
}

@Composable
fun PantallaAutores(autores: List<Autor>, volver: () -> Unit) {
    Column(Modifier.fillMaxSize()) {
        Text("Nuestros autores", style = MaterialTheme.typography.headlineSmall)
        Text("${autores.size} autores", style = MaterialTheme.typography.bodyMedium)
        Button(onClick = volver, modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp)) {
            Text("Volver a libros")
        }
        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp), modifier = Modifier.weight(1f)) {
            items(autores, key = { it.id }) { autor ->
                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text(autor.nombre, style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold)
                        Text(autor.obtenerDescripcion())
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VistaPreviaLibreria() { LibreriaApp() }
