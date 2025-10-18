package core.biblioteca;

public class Autor {
    private static int contador = 1; // semilla compartida por todos los productos
    private String id;
    private String nombre;
    private String nacionalidad;

    public  Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.id = generadorClaveProducto();
    }

    public String mostrarInfo() {
        return "id: "+id+", nombre: "+nombre+", nacionalidad: "+nacionalidad;
    }

    private String generadorClaveProducto() {
        // por convención siempre guardamos en mayúsculas
        String inicialCategoria = nombre.substring(0, 1).toUpperCase();;
        String inicialNombre = nacionalidad.substring(0, 1).toUpperCase();
        return inicialCategoria + inicialNombre + contador++;
    }
}
