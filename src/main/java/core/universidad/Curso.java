package core.universidad;

import utils.ContextColor;
import utils.UtilsColor;

import java.util.Objects;

public class Curso {
    private static int contador = 1; // semilla para auto generar los código
    private String codigo; // código único
    private String nombre;
    private Profesor profesor;

    public Curso(String nombre) {
        this.nombre = nombre;
        this.codigo = generadorClaveCurso();
    }

    public void setProfesor(Profesor profesor) {
        // manejar syncro, si tiene profesor previo se pisa con nuevo
        this.profesor = profesor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return Objects.equals(codigo, curso.codigo) && Objects.equals(nombre, curso.nombre) && Objects.equals(profesor, curso.profesor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, profesor);
    }

    // métodos auxiliares
    private String generadorClaveCurso() {
        // por convención siempre guardamos en mayúsculas
        String inicialesNombre = nombre.substring(0, 3).toUpperCase();;
        return inicialesNombre + contador++;
    }

    public void mostrarInfo() {
        UtilsColor.imprimirBloque(ContextColor.INFO, "Datos del curso");
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Código: "+codigo);
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Nombre: "+nombre);
        profesor.mostrarInfo();
    }

    public String getCodigoCurso() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
}
