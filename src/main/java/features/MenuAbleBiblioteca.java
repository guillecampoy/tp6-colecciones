package features;

import core.SubMenu;
import data.DataStore;
import utils.ContextColor;
import utils.UtilsColor;

public class MenuAbleBiblioteca extends SubMenu {
    private boolean flagInit = false;

    public MenuAbleBiblioteca(String titulo) {
        super(titulo);
    }

    @Override
    protected void imprimirOpciones() {
        System.out.println("1. Set up inicial (1 por ejecución, se maneja fallo con un flag)");
        System.out.println("2. Listar libros");
        System.out.println("3. Buscar libro por ISBN");
        System.out.println("4. Filtrado de libros por año de publicación");
        System.out.println("5. Eliminar libro por ISBN (listar restantes)");
        System.out.println("6. Cantidad total de libros");
        System.out.println("7. listado de Autores disponibles");
        System.out.println("0.  Volver");
    }

    @Override
    protected boolean resolverOpcion(int opcion) {
        switch (opcion) {
            case 1 -> setupInicial();
            case 2 -> listarLibros();
            case 3 -> buscarLibro();
            case 4 -> filtradoPorAnio();
            case 5 -> eliminarLibro();
            case 6 -> cantidadTotal();
            case 7 -> listadoDeAutores();
            default -> { return false; }
        }
        return true;
    }

    private void setupInicial() {
        if (!flagInit) {
            System.out.println("Creando biblioteca con datos iniciales...");
            System.out.println("Se cargaron Autores, Libros vinculados con autores, se agregan a la biblioteca");
            fixtures.biblioteca.BibliotecaFixture.cargar();
            System.out.println("→ Datos iniciales cargados de forma correcta.");
        } else {
            UtilsColor.imprimirBloque(ContextColor.ERROR, "La biblioteca ya fue inicializada previamente..");
        }
        flagInit = true;
    }

    private void listarLibros() {
        if (DataStore.BIBLIOTECA.getLibros().isEmpty()) {
            UtilsColor.imprimirBloque(ContextColor.ERROR,"Sin productos");
            return;
        }
        DataStore.BIBLIOTECA.listarLibros();
    }

    private void buscarLibro() {
        System.out.println("Ingrese el ISBN");
        String isbn = scanner.nextLine().trim().toUpperCase();
        DataStore.BIBLIOTECA.buscarLibroIsbn(isbn);
    }

    private void filtradoPorAnio() {
        System.out.println("Ingrese el año por el cual quiere filtrar");
        int anioPublicacion = scanner.nextInt();
        DataStore.BIBLIOTECA.filtradoPorAnio(anioPublicacion);
    }

    private void eliminarLibro() {
        System.out.println("Ingrese el ISBN del libro a eliminar");
        String isbn = scanner.nextLine().trim().toUpperCase();
        DataStore.BIBLIOTECA.eliminarLibroPorIsbn(isbn);
    }

    private void cantidadTotal() {
        UtilsColor.imprimirBloque(ContextColor.INFO, "Cantidad total de librios: "+DataStore.BIBLIOTECA.obtenerCantidadLibros());
    }

    private void listadoDeAutores() {
        DataStore.BIBLIOTECA.mostrarAutoresDisponibles();
    }
}
