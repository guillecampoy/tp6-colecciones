package app;

import core.SubMenuAble;
import features.MenuAbleBiblioteca;
import features.MenuAbleSisitemaStock;
import features.MenuAbleUniversidad;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();
            SubMenuAble ejercicio = obtenerEjercicio(opcion);
            if (ejercicio != null) {
                ejercicio.execute();
            } else if (opcion != 0) {
                System.out.println("Opción no válida");
            }
            if (opcion != 0) {
                System.out.println("Presiona Enter para continuar...");
                scanner.nextLine();
            }

        }
        while (opcion != 0);
        System.out.println("Chau!");
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===========================================================");
        System.out.println("   Trabajo Práctico 6 - Colecciones y Enumeraciones");
        System.out.println("===========================================================");
        System.out.println("Seleccionae Ejercicio");
        System.out.println("1. Sistema de stock");
        System.out.println("2. Biblioteca y libros");
        System.out.println("3. Universidad, profesor y curso");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion () {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static SubMenuAble obtenerEjercicio(int opcion) {
        return switch (opcion) {
            case 1  -> new MenuAbleSisitemaStock("Sistema de Stock");
            case 2  -> new MenuAbleBiblioteca("Biblioteca");
            case 3  -> new MenuAbleUniversidad("Sistema docentes, profesores y cursos");
            default -> null;
        };
    }
}