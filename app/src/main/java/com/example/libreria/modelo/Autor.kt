package com.example.libreria.modelo

class Autor(val id: Int, val nombre: String, val nacionalidad: String) {
    fun obtenerDescripcion(): String = "$nombre • $nacionalidad"
}
