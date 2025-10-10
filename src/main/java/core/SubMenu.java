package core;

import utils.ContextColor;
import utils.UtilsColor;

import java.util.Scanner;

public abstract class SubMenu implements SubMenuAble {

    private final String titulo;
    // Un único Scanner compartido para todos los submenús
    protected static final Scanner scanner = new Scanner(System.in);

    protected SubMenu(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public final void execute() {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerOpcion();

            if (opcion == 0) break;

            boolean ok = resolverOpcion(opcion);
            if (!ok) {
                UtilsColor.imprimirBloque(ContextColor.ERROR, "Opción inválida");
            }
            System.out.println("Presiona Enter para continuar...");
            scanner.nextLine();
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        UtilsColor.imprimirBloque(ContextColor.WARNING,"===========================================================");
        System.out.println("   " + titulo);
        UtilsColor.imprimirBloque(ContextColor.WARNING,"===========================================================");
        imprimirOpciones();
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Seleccione una opción: ");
    }

    private int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Imprime las opciones (por ejemplo 1..3 y 0 para volver).
     */
    protected abstract void imprimirOpciones();

    /**
     * Resuelve la opción seleccionada.
     * Debe devolver true si la opción existe y fue atendida; false si es inválida.
     */
    protected abstract boolean resolverOpcion(int opcion);
}