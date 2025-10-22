package core.biblioteca;

import utils.ContextColor;
import utils.UtilsColor;

public class Libro {
    private String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor;

    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
        this.autor = autor;
    }

    public void mostrarInfo() {
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Titulo: "+titulo);
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Isbn: "+isbn);
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Año publicación: "+anioPublicacion);
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Autor: "+autor.mostrarInfo());
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnio() {
        return anioPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }
}
