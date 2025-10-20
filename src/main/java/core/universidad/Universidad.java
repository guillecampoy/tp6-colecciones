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

    // Métodos soporte para reforzar usabilidad
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



    /*
• eliminarCurso(String codigo) → Debe romper la relación con su profesor
si la hubiera.
• eliminarProfesor(String id) → Antes de remover, dejar null los cursos que
dictaba.
Tareas a realizar
Crear al menos 3 profesores y 5 cursos.
Agregar profesores y cursos a la universidad.
Asignar profesores a cursos usando asignarProfesorACurso(...).
Listar cursos con su profesor y profesores con sus cursos.
Cambiar el profesor de un curso y verificar que ambos lados quedan
sincronizados.
Remover un curso y confirmar que ya no aparece en la lista del profesor.
Remover un profesor y dejar profesor = null,
Mostrar un reporte: cantidad de cursos por profesor.
     */
}

