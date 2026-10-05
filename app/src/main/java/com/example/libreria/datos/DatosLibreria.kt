package com.example.libreria.datos

import com.example.libreria.modelo.Autor
import com.example.libreria.modelo.Libro

object DatosLibreria {
    val autores = listOf(
        Autor(1, "Gabriel García Márquez", "Colombiana"),
        Autor(2, "Isabel Allende", "Chilena")
    )
    // Precios y existencias ficticios para la demostración.
    val libros = listOf(
        Libro(1, "Cien años de soledad", 95.0, 5, autores[0]),
        Libro(2, "El amor en los tiempos del cólera", 85.0, 0, autores[0]),
        Libro(3, "La casa de los espíritus", 90.0, 3, autores[1])
    )
}
