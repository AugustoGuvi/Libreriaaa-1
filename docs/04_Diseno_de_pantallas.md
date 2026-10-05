# Checkpoint 4: diseño de interfaz
Consultar bocetos.svg: es un diseño previo, no una captura de ejecución.

## Pantalla 1: catálogo de libros
Encabezado Mi librería, subtítulo, título Catálogo de libros, contador y botón Ver autores.
Lista vertical de tres libros con título, autor, precio y disponibilidad. Los libros usan los métodos del modelo.

## Pantalla 2: autores
Mismo encabezado, título Nuestros autores, contador y botón Volver a libros.
Lista vertical de dos autores con nombre y descripción de nacionalidad.

| Componente | Uso |
|---|---|
| Scaffold | Estructura general y espacio para las barras del sistema |
| Column | Distribución vertical |
| Text | Títulos y atributos de los objetos |
| Button | Cambio entre las dos pantallas |
| LazyColumn e items | Listas desplazables con identificadores estables |
| Card | Agrupación visual de cada objeto |
| Spacer | Separación del encabezado |
| MaterialTheme | Colores y tipografía coherentes |
| Modifier | Tamaño, márgenes y relleno |

rememberSaveable conserva la pantalla seleccionada al rotar el dispositivo.
BackHandler permite volver de autores a libros con el botón Atrás del sistema.
Los botones ocupan todo el ancho y las tarjetas crecen con el contenido. Las listas permiten desplazamiento.
