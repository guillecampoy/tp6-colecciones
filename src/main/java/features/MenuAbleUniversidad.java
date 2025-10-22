package features;

import core.SubMenu;
import core.universidad.Curso;
import core.universidad.Profesor;
import data.DataStore;
import utils.ContextColor;
import utils.UtilsColor;

public class MenuAbleUniversidad extends SubMenu {
    private boolean flagInit = false;

    public MenuAbleUniversidad(String titulo) {
        super(titulo);
    }

    @Override
    protected void imprimirOpciones() {
        System.out.println("1. Set up inicial (1 por ejecución, se maneja fallo con un flag)");
        System.out.println("2. Agregar profesor");
        System.out.println("3. Agregar curso");
        System.out.println("4. Asignar profesor a curso");
        System.out.println("5. Listado de profesores (con sus cursos)");
        System.out.println("6. Listado de cursos con sus profesores");
        System.out.println("7. Cambio de profesor asignado al curso");
        System.out.println("8. Eliminar curso");
        System.out.println("9. Eliminar profesor (dejando null asignación en cursos)");
        System.out.println("10. Reporte de profesores");
        System.out.println("0.  Volver");
    }

    @Override
    protected boolean resolverOpcion(int opcion) {
        switch (opcion) {
            case 1  -> setupInicial();
            case 2  -> agregarProfesor();
            case 3  -> agregarCurso();
            case 4  -> asignarProfesor();
            case 5  -> listadoProfesores();
            case 6  -> listadoCursos();
            case 7  -> cambioProfesor();
            case 8  -> eliminarCurso();
            case 9  -> eliminarProfesor();
            case 10 -> reporteProfesores();
            default -> { return false; }
        }
        return true;
    }

    private void setupInicial() {
        if (!flagInit) {
            System.out.println("Creando Universidad con datos iniciales...");
            System.out.println("Se cargaron Profesores y cursos vinculados con profesores, se agregan a la universidad");
            fixtures.universidad.UniversidadFixture.cargar();
            System.out.println("→ Datos iniciales cargados de forma correcta.");
        } else {
            UtilsColor.imprimirBloque(ContextColor.ERROR, "La universidad ya fue inicializada previamente..");
        }
        flagInit = true;
    }

    private void agregarProfesor() {
        System.out.println("Ingrese nuevo profesor");
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Nombre del profesor: ",'n');
        String nombre = scanner.nextLine();
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Especialidad: ",'n');
        String especialidad = scanner.nextLine();
        Profesor profesor = new Profesor(nombre, especialidad);
        DataStore.UNIVERSIDAD.agregarProfesor(profesor);
        UtilsColor.imprimirBloque(ContextColor.SUCCESS, "Profesor agregado correctamente");
    }

    private void agregarCurso() {
        System.out.println("Ingrese nuevo curso");
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Nombre: ",'n');
        String nombreCurso = scanner.nextLine();
        Curso curso = new Curso(nombreCurso);
        DataStore.UNIVERSIDAD.agregarCurso(curso);
        UtilsColor.imprimirBloque(ContextColor.SUCCESS, "Curso agregado correctamente");
    }

    private void asignarProfesor() {
        System.out.println("Se asignarán de forma automática 3 profesores a 5 cursos");
        asignacionAutomatica();
        DataStore.UNIVERSIDAD.listadoProfesores();
    }

    private void listadoProfesores() {
        DataStore.UNIVERSIDAD.listadoProfesores();
    }

    private void listadoCursos() {
        DataStore.UNIVERSIDAD.listadoCursos();
    }

    private void cambioProfesor() {
        // Re asignamos materia de Arquitectura
        Curso materia = DataStore.UNIVERSIDAD.getCursos().get(5); // arquitectura
        Profesor nuevoProfe = DataStore.UNIVERSIDAD.getProfesores().get(4); // Profesor sin asignación en carga inicial
        DataStore.UNIVERSIDAD.asignarProfesor(materia.getCodigoCurso(), nuevoProfe.getId());
        // Agregar verificación
    }

    private void eliminarCurso() {
        // Se eliminarán dos cursos uno sin docente asignado y otro con docente asignado
        // Curso SIN docente programación web
        Curso cursoSinAsignacionEliminado = DataStore.UNIVERSIDAD.getCursos().get(6);
        Curso cursoConDocenteAsignado = DataStore.UNIVERSIDAD.getCursos().get(5);

        // listar profesores primero con sus cursos

        // Eliminación //
        // Curso sin docente
        DataStore.UNIVERSIDAD.eliminarCurso(cursoSinAsignacionEliminado.getCodigoCurso());

        // Curso con docente
        DataStore.UNIVERSIDAD.eliminarCurso(cursoConDocenteAsignado.getCodigoCurso());

        // listar profesores al final (que se elimine el curso)
    }

    private void eliminarProfesor() {
        // Se eliminarán dos casos un docente con cursos y otro sin cursos
        Profesor profeSinCursos = DataStore.UNIVERSIDAD.getProfesores().get(3);
        Profesor profeConCursos = DataStore.UNIVERSIDAD.getProfesores().get(1); // Dos cursos de inglés

        // listar cursos con sus profesores

        // Eliminación //
        // Profe sin cursos
        DataStore.UNIVERSIDAD.eliminarProfesor(profeSinCursos.getId());

        // Profe con cursos
        DataStore.UNIVERSIDAD.eliminarCurso(profeConCursos.getId());

        // Evidenciar cursos con Asignación null

    }

    private void reporteProfesores() {
        DataStore.UNIVERSIDAD.listadoProfesores();
    }

    // métodos helpers o utilitarios

    private static void asignacionAutomatica() {
        Profesor profesor = DataStore.UNIVERSIDAD.getProfesores().getFirst(); // progra
        Profesor profesor2 = DataStore.UNIVERSIDAD.getProfesores().get(1); // inglés
        Profesor profesor3 = DataStore.UNIVERSIDAD.getProfesores().get(2); // arquitectura

        //profe uno materisas x2
        Curso cursoUnoProfesor = DataStore.UNIVERSIDAD.getCursos().getFirst(); // Progra2
        Curso cursoDosProfesor = DataStore.UNIVERSIDAD.getCursos().get(1); // Base de datos

        // profe2 materias x2
        Curso cursoUnoProfesor2 = DataStore.UNIVERSIDAD.getCursos().get(3); // Inglés I
        Curso cursoDosProfesor2 = DataStore.UNIVERSIDAD.getCursos().get(4); // Inglés II

        // profe3 materias x1
        Curso cursoUnoProfesor3 = DataStore.UNIVERSIDAD.getCursos().get(5); // Arquitectura

        DataStore.UNIVERSIDAD.asignarProfesor(cursoUnoProfesor.getCodigoCurso(), profesor.getId());
        DataStore.UNIVERSIDAD.asignarProfesor(cursoDosProfesor.getCodigoCurso(), profesor.getId());
        DataStore.UNIVERSIDAD.asignarProfesor(cursoUnoProfesor2.getCodigoCurso(), profesor2.getId());
        DataStore.UNIVERSIDAD.asignarProfesor(cursoDosProfesor2.getCodigoCurso(), profesor2.getId());
        DataStore.UNIVERSIDAD.asignarProfesor(cursoUnoProfesor3.getCodigoCurso(), profesor3.getId());
    }

}
