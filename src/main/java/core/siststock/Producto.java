package core.siststock;

import utils.ContextColor;
import utils.UtilsColor;

public class Producto {
    private static int contador = 1; // semilla compartida por todos los productos
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;

    public Producto(String nombre, double precio, int cantidad, CategoriaProducto categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.id = generadorClaveProducto();
    }

    private String generadorClaveProducto() {
        // por convención siempre guardamos en mayúsculas
        String inicialCategoria = categoria.name().substring(0, 1).toUpperCase();;
        String inicialNombre = nombre.substring(0, 1).toUpperCase();
        return inicialCategoria + inicialNombre + contador++;
    }

    public void mostrarInfo() {
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Id: " + id);
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Nombre: " + nombre);
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Precio: " + precio);
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Cantidad: " + cantidad);
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Categoria: " + categoria);
    }

    public String getId(){
        return id;
    }

    public void setStock(int nuevaCantidad) {
        this.cantidad = nuevaCantidad;
    }

    public CategoriaProducto getCategoria() {
        return categoria;
    }

    public int getStock() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
