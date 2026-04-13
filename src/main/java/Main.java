/*
Clase Main
Punto de entrada
Muestra el menú
Lee opciones elegidas por el usuario
Llama a los métodos correspondientes del Biblioteca Controller según el caso
*/


import controller.BibliotecaController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BibliotecaController bibliotecaController = new BibliotecaController();
        int opcion;

        do {
            System.out.println("-----\nMENU BIBLIOTECA\n-----");
            System.out.println("1-Importar Libros");
            System.out.println("2-Buscar Libro por id");
            System.out.println("3-Marcar Libro como Favorito");
            System.out.println("4-Exportar Favoritos");
            System.out.println("5-Importar Favoritos");
            System.out.println("6-Mostrar todos los libros");
            System.out.println("7-Mostrar favoritos");
            System.out.println("8-Salir");
            System.out.println("Elige una opción");

            opcion = sc.nextInt();


            switch (opcion){

                case 1->{bibliotecaController.cargarLibrosDesdeAPI();}
                case 2->{
                    System.out.println("Introduce el id del Libro");
                    int id = sc.nextInt();
                    bibliotecaController.mostrarLibroId(id);
                }
                case 3->{
                    System.out.println("Introduce el id del libro que quieres marcar como favorito");
                    int id = sc.nextInt();
                    sc.nextLine();
                    bibliotecaController.marcarFavorito(id);
                }
                case 4->{
                    bibliotecaController.exportarFavoritos();
                }
                case 5->{bibliotecaController.importarFavoritos();}
                case 6->{bibliotecaController.mostrarCatalogo();}
                case 7->{bibliotecaController.mostrarFavoritos();}
                case 8->{System.out.println("Saliendo ....");
                bibliotecaController.exportarFavoritos();}
                default -> {System.out.println("Opción nó válida");}
            }

        }while (opcion!=8);

        sc.close();

    }
}
