package core.siststock;

import utils.ContextColor;
import utils.UtilsColor;

import java.util.ArrayList;

public class Inventario {
    ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void  agregarProducto (Producto producto) {
        productos.add(producto);
    }
    public void listarProductos() {
        UtilsColor.imprimirBloque(ContextColor.INFO, "Listado de productos");
        for (Producto producto : productos) {
            producto.mostrarInfo();
        }
    }
    public void buscarProductoPorId(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                producto.mostrarInfo();
            } else {
                UtilsColor.imprimirBloque(ContextColor.ERROR, "No existe el producto con el id " + id);
            }
        }
    }

    public void eliminarProductoPorId(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                productos.remove(producto);
                UtilsColor.imprimirBloque(ContextColor.WARNING, "Eliminado el producto con el id " + id);
            } else {
                UtilsColor.imprimirBloque(ContextColor.ERROR, "No existe el producto con el id " + id);
            }
        }
    }

    public void actualizarStock(String id, int nuevaCantidad) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                producto.setStock(nuevaCantidad);
                UtilsColor.imprimirBloque(ContextColor.WARNING, "Actualizando stock de producto " + producto.getId());
            } else {
                UtilsColor.imprimirBloque(ContextColor.ERROR, "No existe el producto con el id " + id);
            }
        }
    }

    public void filtrarPorCategoria(CategoriaProducto categoria) {
        for (Producto producto : productos) {
            if (producto.getCategoria().equals(categoria)){
                producto.mostrarInfo();
            }
        }
    }







}
/*
OK ArrayList<Producto> productos Métodos requeridos:
OK agregarproducto(producto p)
OK listarProductos()
OK buscarProductoPorId(String id)
OK eliminarProducto(String id)
OK actualizarStock(String id, int nuevaCantidad)
OK filtrarPorCategoria(CategoriaProducto categoria)
    (Mejora retornar una nueva lista y si está vacia indicar error o que no hay productos )
● obtenerTotalStock()
● obtenerProductoConMayorStock()
● filtrarProductosPorPrecio(double min, double max)
● mostrarCategoriasDisponibles()
 */