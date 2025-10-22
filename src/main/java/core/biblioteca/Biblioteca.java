package core.biblioteca;

import utils.ContextColor;
import utils.UtilsColor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Biblioteca {
    private String nombre;
    private ArrayList<Libro> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    // sobrecargo y permito que se puedan agregar de las dos formas
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
    public void agregarLibro(String isbn, String titulo, int anioPublicacion,  Autor autor) {
        Libro libro = new Libro(isbn, titulo, anioPublicacion, autor);
        agregarLibro(libro);
    }

    public void listarLibros() {
        UtilsColor.imprimirBloque(ContextColor.INFO, "Listado de libros");
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, nombre);
        for (Libro libro : libros) {
            UtilsColor.imprimirBloque(ContextColor.DEFAULT, "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            libro.mostrarInfo();
        }
    }

    public void buscarLibroIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                libro.mostrarInfo();
                return; // los isbn son unicos si lo encuentra retorna
            }
        }
        mensajeErroneoPorDefecto("isbn ingresado");
    }

    public void eliminarLibroPorIsbn(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                libros.remove(libro);
                UtilsColor.imprimirBloque(ContextColor.WARNING, "Eliminado el libro con el isbn: " +isbn);
                UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Actualizando...");
                listarLibros();
                return;
            }
        }
        mensajeErroneoPorDefecto("isbn ingresado");
    }

    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public void filtradoPorAnio(int anioPublicacion) {
        boolean ocurrencias = false;
        for (Libro libro : libros) {
            if (libro.getAnio() == anioPublicacion) {
                libro.mostrarInfo();
                ocurrencias = true;
            }
        }
        if (!ocurrencias) {
            mensajeErroneoPorDefecto("año ingresado");        }
    }

    public void mostrarAutoresDisponibles() {
        // Se utilizará una estructura que NO admite repetidos
        Set<Autor> autoresDisponibles = new HashSet<>();

        // Recorremos los productos y agregamos sus categorías al Set
        for (Libro libro : libros) {
            autoresDisponibles.add(libro.getAutor());
        }

        for (Autor autor : autoresDisponibles) {
            UtilsColor.imprimirBloque(ContextColor.DEFAULT, autor.mostrarInfo());
        }
    }

    // Métodos auxiliares
    private void mensajeErroneoPorDefecto(String contexto) {
        UtilsColor.imprimirBloque(ContextColor.ERROR, "No hay coincidencias para el "+contexto);
    }

}
