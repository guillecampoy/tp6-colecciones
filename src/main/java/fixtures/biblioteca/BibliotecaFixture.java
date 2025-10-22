package fixtures.biblioteca;
import core.biblioteca.Autor;
import data.DataStore;

public class BibliotecaFixture {
    private BibliotecaFixture() {}

    public static void cargar(){
        // Autores
        Autor autorUno = new Autor("Saint-Exupéry", "francés" );
        Autor autorDos = new Autor("Robert C. Martin", "estadounidense");
        Autor autorTres = new Autor("José Hernández", "argentino");

        //Libros
        DataStore.BIBLIOTECA.agregarLibro("1234555","El Gaucho Martín Fierro", 1872, autorTres);
        DataStore.BIBLIOTECA.agregarLibro("1234888","Los treinta y tres orientales", 1878, autorTres);
        DataStore.BIBLIOTECA.agregarLibro("1234222","La vuelta de Martín Fierro", 1879, autorTres);
        DataStore.BIBLIOTECA.agregarLibro("1234111","El principito", 1943, autorUno);
        DataStore.BIBLIOTECA.agregarLibro("1234000","Clean Code: A Handbook of Agile Software Craftsmanship", 2009, autorDos);
        DataStore.BIBLIOTECA.agregarLibro("1234231","Clean Architecture: A Craftsman's Guide to Software Structure and Design", 2017, autorDos);
    }
}
