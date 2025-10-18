package data;

import core.biblioteca.Biblioteca;
import core.siststock.Inventario;

public final class DataStore {
    private DataStore() { }

    public static final Inventario INVENTARIO = new Inventario();

    public static final Biblioteca BIBLIOTECA = new Biblioteca("Biblioteca Nacional");

/*
    public static final List<Profesor> PROFESORES  = new ArrayList<>();

    public static final List<Curso>    CURSOS      = new ArrayList<>();
     */

}
