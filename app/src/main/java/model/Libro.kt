package com.example.catlogogeneral.model

data class Libro(
    val id: Int,
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int,
    val genero: String,
    val rating: Double,
    val resenasCount: Int,
    val sinopsis: String,
    val categoria: String = "Libros"
)

val listaLibrosDummy = listOf(
    Libro(
        id = 1,
        titulo = "Sapiens: De Animales a Dioses",
        autor = "Yuval Noah Harari",
        anioPublicacion = 2011,
        genero = "Historia / Antropología",
        rating = 4.5,
        resenasCount = 1234,
        sinopsis = "Un recorrido fascinante por la historia de la humanidad, desde los primeros homínidos hasta las revoluciones tecnológica y biotecnológica."
    ),
    Libro(
        id = 2,
        titulo = "1984",
        autor = "George Orwell",
        anioPublicacion = 1949,
        genero = "Ciencia Ficción / Distopía",
        rating = 4.8,
        resenasCount = 3500,
        sinopsis = "Una inquietante novela distópica sobre el totalitarismo, la vigilancia masiva y el control del pensamiento."
    ),
    Libro(
        id = 3,
        titulo = "Cien Años de Soledad",
        autor = "Gabriel García Márquez",
        anioPublicacion = 1967,
        genero = "Realismo Mágico",
        rating = 4.9,
        resenasCount = 2800,
        sinopsis = "La obra maestra que narra la historia multi-generacional de la familia Buendía en el pueblo ficticio de Macondo."
    ),
    Libro(
        id = 4,
        titulo = "El Principito",
        autor = "Antoine de Saint-Exupéry",
        anioPublicacion = 1943,
        genero = "Literatura / Filosofía",
        rating = 4.7,
        resenasCount = 4100,
        sinopsis = "Un cuento poético acompañado de reflexiones sobre la vida, el amor y la naturaleza humana."
    ),
    Libro(
        id = 5,
        titulo = "Hábitos Atómicos",
        autor = "James Clear",
        anioPublicacion = 2018,
        genero = "Desarrollo Personal",
        rating = 4.8,
        resenasCount = 1900,
        sinopsis = "Un marco de trabajo práctico para mejorar cada día mediante el cambio de pequeños hábitos cotidianos."
    ),
    Libro(
        id = 6,
        titulo = "Don Quijote de la Mancha",
        autor = "Miguel de Cervantes",
        anioPublicacion = 1605,
        genero = "Novela Clásica",
        rating = 4.6,
        resenasCount = 1500,
        sinopsis = "La célebre aventura del hidalgo Alonso Quijano y su fiel escudero Sancho Panza."
    )
)