package core.universidad;

import utils.ContextColor;
import utils.UtilsColor;

import java.util.ArrayList;

public class Profesor {
    private static int contador = 1; // semilla para auto generar los IDs
    private String id; // clave única de profesor
    private String nombre;
    private String espacialidad;
    private ArrayList<Curso> cursos;

    public Profesor(String nombre, String espacialidad) {
        this.nombre = nombre;
        this.espacialidad = espacialidad;
        this.id = generadorClaveProfesor();
        this.cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso nuevoCurso) {
        if (nuevoCurso == null) return;
        if (cursos.add(nuevoCurso)) {
            if (nuevoCurso.getProfesor() != this) {
                nuevoCurso.setProfesor(this);
            }
        }
    }

    public void eliminarCurso(Curso curso) {
        if (curso == null) return;
        if (cursos.remove(curso)) {
            if (curso.getProfesor() == this) {
                curso.setProfesor(null);
            }
        }
    }

    public void listadoCursos(){
        UtilsColor.imprimirBloque(ContextColor.INFO, "Listado de cursos de profesor");
        for (Curso curso : cursos) {
            UtilsColor.imprimirBloque(ContextColor.DEFAULT, "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            curso.mostrarInfo();
        }
    }

    public void mostrarInfo() {
        UtilsColor.imprimirBloque(ContextColor.INFO, "Datos del profesor");
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Nombre: "+nombre);
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Especialidad: "+espacialidad);
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Cantidad de cursos: "+cursos.size());
    }

    // métodos auxiliares
    private String generadorClaveProfesor() {
        // por convención siempre guardamos en mayúsculas
        String inicialesNombre = nombre.substring(0, 2).toUpperCase();;
        String inicialesEspecialidad = espacialidad.substring(0, 3).toUpperCase();
        return inicialesNombre + inicialesEspecialidad + contador++;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }
}