# Checkpoint 6: comprobación real pendiente
No se ha ejecutado la aplicación en Android Studio ni en un emulador en el entorno de preparación.
Este documento es un procedimiento de verificación, no evidencia de una prueba ya realizada.

1. Abrir la carpeta Libreria en Android Studio y esperar la sincronización.
2. Usar JDK 17 para Gradle e instalar Android SDK Platform 35 si se solicita.
3. Ejecutar en la terminal: .\gradlew.bat :app:assembleDebug
4. Confirmar BUILD SUCCESSFUL y guardar una captura como docs/compilacion.png.
5. Seleccionar un emulador o dispositivo con Android 7.0/API 24 o superior y pulsar Run.
6. Confirmar los tres libros, sus precios y el estado Agotado del segundo libro.
7. Pulsar Ver autores y confirmar los dos autores.
8. Pulsar Volver a libros. Comprobar también Atrás del sistema desde autores.
9. Rotar el dispositivo desde autores: debe conservar esa pantalla.
10. Guardar capturas reales como docs/pantalla_libros.png y docs/pantalla_autores.png.
11. Agregar las capturas al repositorio y hacer el commit de ejecución.

No aceptar sugerencias automáticas de actualizar dependencias durante la primera prueba.
Si falla, revisar el primer error del panel Build; no cambiar versiones al azar.

Intento de compilación durante la preparación: Gradle no pudo descargarse por UnknownHostException para services.gradle.org. El entorno tampoco dispone del SDK de Android. Por ello no se afirma que la aplicación esté compilada o ejecutada.
