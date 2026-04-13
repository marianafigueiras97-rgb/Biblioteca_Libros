/*
Clase controller
Se encarga los archivos locales
Exporta e importa los libros favoritos desde favoritos.obj
 */

package controller;

import lombok.Data;
import model.Libro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Data
public class FileController {

    private String rutaFavoritos = "src/main/resources/favoritos.obj";
    File file;

    public void exportarFavoritos(List<Libro> favoritos){
        /*
        abre el archivo favoritos.obj
        escribe los objetos libros en el
        controlla excepciones
         */
        file = new File(rutaFavoritos);
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(favoritos);
            System.out.println("Favoritos exportados correctamente");

        } catch (IOException e) {
            System.out.println("Error al exportar"+e.getMessage());
        }finally {
            try{
                if (objectOutputStream != null){
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<Libro> importarFavoritos(){
        /*
        abre el archivo favoritos.obj
        lee los objetos libros en el
        devuelbe una lista de objetos Libro
        controlla excepciones
         */
        file = new File(rutaFavoritos);
        ObjectInputStream objectInputStream = null;

        try{
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            return (List<Libro>) objectInputStream.readObject();

        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error al importar favoritos "+e.getMessage());
            return new ArrayList<>();
        }finally {
            try{
                if (objectInputStream != null){
                    objectInputStream.close();
                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
