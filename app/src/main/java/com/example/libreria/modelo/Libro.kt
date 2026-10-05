package com.example.libreria.modelo

import java.util.Locale

class Libro(
    val id: Int,
    val titulo: String,
    val precio: Double,
    val stock: Int,
    val autor: Autor
) {
    init {
        require(precio >= 0) { "El precio no puede ser negativo" }
        require(stock >= 0) { "El stock no puede ser negativo" }
    }
    fun obtenerDetalle(): String = "$titulo — ${autor.nombre}"
    fun obtenerPrecioFormateado(): String = String.format(Locale.US, "Bs %.2f", precio)
    fun estaDisponible(): Boolean = stock > 0
}
