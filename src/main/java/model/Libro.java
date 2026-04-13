/*
Modelo Libro
Almacena los datos de un libro que viene del JSON del API
 */

package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Libro implements Serializable {
    private long id;
    private long year;
    private String title;
    private String handle;
    private String publisher;
    private String isbn;
    private long pages;
    private static long serialVersionUID = 1L;

    public String toString (){
        return String.format("id: %d, year: %d, title: %s, handle: %s, publisher: %s,isbn: %s,pages: %d",
                getId(),
                getYear(),
                getTitle(),
                getHandle(),
                getPublisher(),
                getIsbn(),
                getPages());
    }
}
