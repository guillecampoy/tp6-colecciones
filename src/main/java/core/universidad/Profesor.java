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
        String baseNombre = nombre == null ? "" : nombre.trim();
        String baseEspecialidad = espacialidad == null ? "" : espacialidad.trim();
        String parcialNombre = baseNombre.isEmpty() ? "PR" : baseNombre.substring(0, Math.min(2, baseNombre.length()));
        String parcialEspecialidad = baseEspecialidad.isEmpty() ? "ESP" : baseEspecialidad.substring(0, Math.min(3, baseEspecialidad.length()));
        String inicialesNombre = parcialNombre.toUpperCase();
        String inicialesEspecialidad = parcialEspecialidad.toUpperCase();
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
