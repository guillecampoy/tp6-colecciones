package data;

import core.biblioteca.Biblioteca;
import core.siststock.Inventario;
import core.universidad.Universidad;

public final class DataStore {
    private DataStore() { }

    public static final Inventario INVENTARIO = new Inventario();

    public static final Biblioteca BIBLIOTECA = new Biblioteca("Biblioteca Nacional");

    public static final Universidad UNIVERSIDAD  = new Universidad("Universidad Tecnológica Nacional - UTN");

}
