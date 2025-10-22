package core.universidad;

import utils.ContextColor;
import utils.UtilsColor;

import java.util.ArrayList;

public class Universidad {

    private String nombre;
    private ArrayList<Profesor> profesores;
    private ArrayList<Curso> cursos;

    public Universidad(String nombre) {
        this.nombre = nombre;
        this.profesores = new ArrayList<>();
        this.cursos = new ArrayList<>();
    }

    public void agregarProfesor(Profesor profesor) {
        this.profesores.add(profesor);
    }

    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
    }

    public void asignarProfesor(String codigoCurso, String idProfesor) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        if (curso == null) {
            UtilsColor.imprimirBloque(ContextColor.ERROR, "Curso no encontrado");
            return;
        }

        Profesor profesor = buscarProfesor(idProfesor);
        if (profesor == null) {
            UtilsColor.imprimirBloque(ContextColor.ERROR, "Profesor no encontrado");
            return;
        }

        curso.setProfesor(profesor);
        UtilsColor.imprimirBloque(ContextColor.SUCCESS,
                "Profesor " + profesor.getNombre() + ", con id:"+ profesor.getId()
                        + " asignado a curso " + curso.getNombre() +", con código: "+curso.getCodigoCurso());
    }

    private Curso buscarCursoPorCodigo(String codigo) {
        for (Curso c : cursos) {
            if (c.getCodigoCurso().equals(codigo)) {
                return c;
            }
        }
        return null;
    }

    private Profesor buscarProfesor(String id) {
        for (Profesor p : profesores) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void listadoCursos() {
        UtilsColor.imprimirBloque(ContextColor.INFO, "Listado de cursos");
        for (Curso curso : cursos) {
            UtilsColor.imprimirBloque(ContextColor.DEFAULT, "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            curso.mostrarInfo();
        }
    }

    public void listadoProfesores() {
        UtilsColor.imprimirBloque(ContextColor.INFO, "Listado de profesores");
        for (Profesor profesor : profesores) {
            UtilsColor.imprimirBloque(ContextColor.DEFAULT, "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            profesor.mostrarInfo();
        }
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void eliminarCurso(String curso) {
        Curso cursoAEliminar = buscarCursoPorCodigo(curso);

        if (curso == null) {
            UtilsColor.imprimirBloque(ContextColor.ERROR, "Curso no encontrado");
            return;
        }
        // Se iteran todos los profesores y se asigna null si hay igualdad con curso borrado
        for (Profesor profesor : profesores) {
            if ((profesor.getCursos().contains(cursoAEliminar))) {
                profesor.eliminarCurso(cursoAEliminar);
                UtilsColor.imprimirBloque(ContextColor.INFO, "Curso eliminado, se quita de lista del docente: "+profesor.getNombre());
                // Se elimina de la lista de cursos
                cursos.remove(cursoAEliminar);
                return; // la asignación es única si hay equivalencia retorno
            }
        }
        UtilsColor.imprimirBloque(ContextColor.WARNING, "No había docente asignado al curso, curso eliminado");
        cursos.remove(cursoAEliminar);
    }

    public void eliminarProfesor(String id) {
        Profesor profesorAEliminar = buscarProfesor(id);
        if (profesorAEliminar == null) {
            UtilsColor.imprimirBloque(ContextColor.ERROR, "Curso no encontrado");
            return;
        }
        // Se iteran todos los cursos y se asigna null si hay igualdad con profesor borrado
        for (Curso curso : cursos) {
            if (curso.getProfesor() != null && curso.getProfesor().equals(profesorAEliminar)){
                curso.setProfesor(null);
                UtilsColor.imprimirBloque(ContextColor.INFO, "Nuevo curso sin docente: "+curso.getNombre());
            }
        }
        UtilsColor.imprimirBloque(ContextColor.WARNING, "Profesor eliminado: "+profesorAEliminar.getNombre());
    }
}

