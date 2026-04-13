/*
Modelo Biblioteca
Representa un conjunto de libros
Guarda:
- La lista de libros importados desde la API
- La lista de libros favoritos
Gestiona esos libros favoritos permitiendo que se muestren o se añadan a la lista
 */

package model;

import lombok.Data;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class Biblioteca {
    private List<Libro> libros;
    private List<Libro> favoritos;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.favoritos = new ArrayList<>();

    }

    public Libro buscarLibroId (int id){
        /*
        Recorre la lista de libros
        Si lo escuentra lo devuelve
        Si no lo encuentra devuelve null
         */
        for (Libro libro: libros){
            if (libro.getId()==id){
                return  libro;
            }
        }
        return null;
    }

    public boolean agregarFavorito (int id){
        /*
        Crea un libro nuevo para poder meterlo en la lista favoritos
        Condicion de si el libro que estoy intentando meter no da nulo y ademas no está dentro de la lista de favoritos lo añade a la lista y devuelve true
        Si el libro es null o ya esta en la lista devuelve false
         */
        Libro libro = buscarLibroId(id);
        if (libro != null && !favoritos.contains(libro)){
            favoritos.add(libro);
            return true;
        }
        return false;
    }

    public void mostrarLibros(){
        /*
        Recorre la lista de libros e imprime
         */
        if (libros.isEmpty()){
            System.out.println("No hay libros en el sistema");
        }else {
            for (Libro libro : libros){
                System.out.println(libro);
            }
        }
    }

    public void mostrarFavoritos(){
        /*
        Recorre la lista de favoritos e imprime
         */
        if (favoritos.isEmpty()){
            System.out.println("No hay favoritos guardados todavía");
        }else {
            for (Libro fav : favoritos){
                System.out.println(fav);
            }
        }
    }


}
