package fixtures.universidad;

import core.universidad.Curso;
import core.universidad.Profesor;
import data.DataStore;

public class UniversidadFixture {

    private UniversidadFixture() {}

    public static void cargar() {
        // Profesores
        Profesor profeUNO = new Profesor("Giuliano Espejo", "Programación");
        Profesor profeDOS = new Profesor("Irene Caram", "Inglés");
        Profesor profeTRES = new Profesor("Diego Sánchez", "Arquitectura");
        Profesor profeCUATRO = new Profesor("Martín Rivas", "Base de datos");
        Profesor profesorCINCO = new Profesor("Facundo D Arano", "Programación");

        // Cursos
        Curso cursoUNO = new Curso("Parogramación 2");
        Curso cursoDos = new Curso("Base de datos");
        Curso cursoTres = new Curso("Base de datos II");
        Curso cursoCuatro = new Curso("Inglés");
        Curso cursoCinco = new Curso("Inglés II");
        Curso cursoSeis = new Curso("Arquitectura y SO");
        Curso cursoSiete = new Curso("Programación Web");

        // Asignación Cursos
        DataStore.UNIVERSIDAD.agregarCurso(cursoUNO);
        DataStore.UNIVERSIDAD.agregarCurso(cursoDos);
        DataStore.UNIVERSIDAD.agregarCurso(cursoTres);
        DataStore.UNIVERSIDAD.agregarCurso(cursoCuatro);
        DataStore.UNIVERSIDAD.agregarCurso(cursoCinco);
        DataStore.UNIVERSIDAD.agregarCurso(cursoSeis);
        DataStore.UNIVERSIDAD.agregarCurso(cursoSiete);

        // Asignación Profesores
        DataStore.UNIVERSIDAD.agregarProfesor(profeUNO);
        DataStore.UNIVERSIDAD.agregarProfesor(profeDOS);
        DataStore.UNIVERSIDAD.agregarProfesor(profeTRES);
        DataStore.UNIVERSIDAD.agregarProfesor(profeCUATRO);
        DataStore.UNIVERSIDAD.agregarProfesor(profesorCINCO);
    }
}
