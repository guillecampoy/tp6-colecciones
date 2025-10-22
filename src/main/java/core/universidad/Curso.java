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
        // Por defento asigno un objeto de la familia Profesor, pero vacío
        this.profesor = null;
    }

    public void setProfesor(Profesor nuevo) {
        if (this.profesor == nuevo) return;

        Profesor anterior = this.profesor;
        this.profesor = nuevo;

        // Quitar del anterior
        if (anterior != null) {
            anterior.eliminarCurso(this);
            UtilsColor.imprimirBloque(ContextColor.WARNING, "Profesor quitado del curso "+anterior.getNombre());
        }
        // Agregar al nuevo
        nuevo.agregarCurso(this);
        UtilsColor.imprimirBloque(ContextColor.SUCCESS, "Nuevo profesor agregado al curso "+nuevo.getNombre());

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

    public Profesor getProfesor() {
        return profesor;
    }
}
