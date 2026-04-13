# Biblioteca Libros

Proyecto en Java para practicar la lectura e interpretación de archivos JSON mediante peticiones a una API externa. La aplicación permite importar libros de Stephen King, consultar información de un libro concreto, gestionar favoritos y exportarlos o importarlos desde un fichero local.

## Objetivo

Este proyecto ha sido desarrollado como práctica de programación orientada a objetos, trabajo con APIs y persistencia de objetos en ficheros.

La aplicación permite:

- Importar el catálogo de libros desde la API de Stephen King.
- Buscar un libro por su identificador.
- Marcar libros como favoritos.
- Exportar favoritos a un fichero `favoritos.obj`.
- Importar favoritos previamente guardados.

## Tecnologías utilizadas

- Java
- Maven
- Lombok
- `HttpClient` de Java
- `org.json`
- Gson

## API utilizada

API pública de Stephen King:

- Catálogo completo: `https://stephen-king-api.onrender.com/api/books`
- Libro por id: `https://stephen-king-api.onrender.com/api/book/{id}`

## Estructura del proyecto

```text
src/
 main/
  java/
   controller/
    ApiController.java
    BibliotecaController.java
    FileController.java
   model/
    Biblioteca.java
    Libro.java
   Main.java
  resources/
   favoritos.obj
```

## Clases principales

### `Libro`

Modela la información de un libro obtenida desde la API.

### `Biblioteca`

Almacena la lista de libros importados y la lista de favoritos.

### `ApiController`

Realiza las peticiones HTTP a la API y transforma el JSON en objetos `Libro`.

### `BibliotecaController`

Coordina la lógica principal del programa y conecta el modelo con los controladores.

### `FileController`

Gestiona la exportación e importación de favoritos mediante serialización en el fichero `favoritos.obj`.

### `Main`

Punto de entrada de la aplicación. Muestra el menú y recoge la interacción del usuario.

## Funcionamiento

Al ejecutar el programa se muestra un menú con varias opciones:

1. Importar libros desde la API.
2. Buscar un libro por id.
3. Marcar un libro como favorito.
4. Exportar favoritos.
5. Importar favoritos.
6. Mostrar catálogo.
7. Mostrar favoritos.
8. Salir.


## Persistencia de favoritos

Los libros favoritos se guardan en el archivo:

```text
src/main/resources/favoritos.obj
```

Este fichero almacena objetos serializados de tipo `Libro`.

## Autor

Proyecto realizado por Mariana Figueiras como práctica de clase.
