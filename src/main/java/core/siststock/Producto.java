package core.siststock;

import utils.ContextColor;
import utils.UtilsColor;

public class Producto {
    private String id;
    private String nombre;
    private double precio;
    private int cantidad;
    private CategoriaProducto categoria;

    public void mostrarInfo() {
        UtilsColor.imprimirBloque(ContextColor.DEFAULT, "Id" + id);
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
