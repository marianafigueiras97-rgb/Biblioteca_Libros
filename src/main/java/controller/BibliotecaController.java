/*
Clase controller
Coordina toda la lógica del programa
Pide los Libros a API Controller
Los guarda en Biblioteca
Añade favoritos en Biblioteca
Llama a File Controller para importar o exportar favoritos
*/

package controller;

import lombok.Data;
import model.Biblioteca;
import model.Libro;
import java.util.List;

@Data

public class BibliotecaController {

    private Biblioteca biblioteca;
    private ApiController apiController;
    private FileController fileController;

    public BibliotecaController() {
        //constructor vacío que instacia las clases que necesito usar
        this.biblioteca = new Biblioteca();
        this.apiController = new ApiController();
        this.fileController = new FileController();
    }

    public void cargarLibrosDesdeAPI (){
        /*
        llama al metodo importarTodosLibro de la clase api controller
        comprueba se la lista de libros esta vacia y lanza mensaje
        si no hace el set de libros y muestra mensaje de exito
         */
        List<Libro> libros = apiController.importarTodosLibros();

        if (libros.isEmpty()){
            System.out.println("No se han podido importar los libros desde la API");
        }else {
            biblioteca.setLibros(libros);
            System.out.println(libros.size()+" libros importados correctamente");
        }
    }
    public void mostrarLibroId(int id){
        /*
        llama al metodo buscarLibro por id de la clase api controller
        commmprueba si existe y lo imprime
         si no lanza mensaje de fallo
         */
        Libro libro = apiController.buscarLibroId(id);

        if (libro!= null){
            System.out.println(libro);
        }else {
            System.out.println("No se ha encontrado ningún libro con id "+id);
        }
    }
    public void marcarFavorito(int id){
        /*
        llama al metodo agregar favorito y lo guarda en una booleana
        comprueba si es true o false y lanza mensaje segun caso
         */


        boolean agregado = biblioteca.agregarFavorito(id);

        if (agregado){
            System.out.println("Libro agregado correctamente ✅");
        }else {
            System.out.println("No se pudo agregar el libro a favoritos ❌");
        }
    }

    public void exportarFavoritos(){
        /*
        llama a los metodos getFavoritos de biblioteca y exportarFavoritos de file controller
        si no hay ninguno nuevo marcado muestra mensaje
        si hay favoritos los exporta
         */
        List<Libro> favoritos = biblioteca.getFavoritos();

        if (favoritos.isEmpty()){
            System.out.println("No hay favoritos todavía");
        }else {
            fileController.exportarFavoritos(favoritos);
        }
    }

    public void importarFavoritos(){
        /*
        llama al metodo  importarFavoritos de file controller
        comprueba si la lista esta vacía o nula
        imprime o muestra mensaje
         */
        List<Libro> favoritosNuevos = fileController.importarFavoritos();

        if (favoritosNuevos == null || favoritosNuevos.isEmpty()){
            System.out.println("No hay nada nuevo que importar");
        }else {
            biblioteca.setFavoritos(favoritosNuevos);
            System.out.println("favoritos importados correctamente");
            for (Libro libro : favoritosNuevos){
                System.out.println(libro);
            }
        }
    }

    public void mostrarCatalogo(){
        /*
        llama al metodo de otra clase
         */
        biblioteca.mostrarLibros();
    }

    public void mostrarFavoritos (){
        /*
        llama al metodo de otra clase
         */
        biblioteca.mostrarFavoritos();
    }

}
