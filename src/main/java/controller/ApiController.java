/*
Clase controller
Se encarga de comunicarse con la API externa, es la que hace las peticiones
Lee el JSON recibido y lo convierte a objeto libro
 */
package controller;

import com.google.gson.Gson;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Libro;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Data
public class ApiController {
    private String urlLibros = "https://stephen-king-api.onrender.com/api/books";
    private String urlLibrosId = "https://stephen-king-api.onrender.com/api/book/";
    private HttpClient client;

    public ApiController(){
        this.client = HttpClient.newHttpClient();
    }

    public List<Libro> importarTodosLibros(){
        /*
        Conecta con la API
        Lee la respuesta
        convierte la respuesta a JSON
        recorre el array de libros
        crea objeto libro
        los añade a la lista
        devuelve uns lista de libros
         */
        List<Libro> libros = new ArrayList<>();

        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(urlLibros))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonLibro = new JSONObject(response.body());
            JSONArray arrayLibros = jsonLibro.getJSONArray("data");

            for (int i = 0; i < arrayLibros.length(); i++) {
                JSONObject libroJSON = arrayLibros.getJSONObject(i);
                Libro libro = parsearLibro(libroJSON);
                libros.add(libro);
            }
        } catch (IOException | InterruptedException e){
            System.out.println("Error al conectar con la API "+e.getMessage());
        }
        return libros;
    }

    public Libro buscarLibroId(int id){
        /*
        conecta con la API
        lee la respuesta
        crea un objeto libro
        lo devuelve
         */
        try {
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(urlLibrosId + id))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            JSONObject libroJSON = jsonResponse.getJSONObject("data");
            return parsearLibro(libroJSON);
        } catch (IOException | InterruptedException e ){
            System.out.println("Error al conectar con la API "+ e.getMessage());
        } catch (Exception e) {
            System.out.println("No se pudo obtener el libro ");
        }
        return null;

    }

    private Libro parsearLibro (JSONObject libroJSON){
        /*
        metoodo privado para convertir el libroJSON que es un JSONObject a Libro
         */
        return new Libro(
                libroJSON.getLong("id"),
                libroJSON.getLong("Year"),
                libroJSON.getString("Title"),
                libroJSON.getString("handle"),
                libroJSON.getString("Publisher"),
                libroJSON.getString("ISBN"),
                libroJSON.getLong("Pages")
        );
    }
}
