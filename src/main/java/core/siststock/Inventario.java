package core.siststock;

import utils.ContextColor;
import utils.UtilsColor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
            UtilsColor.imprimirBloque(ContextColor.DEFAULT, "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            producto.mostrarInfo();
        }
    }
    public void buscarProductoPorId(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                producto.mostrarInfo();
                return; // si encuentra es único, sale del método
            }
        }
        mensajeErroneoPorDefecto("id ingresado");
    }

    public void eliminarProductoPorId(String id) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                productos.remove(producto);
                UtilsColor.imprimirBloque(ContextColor.WARNING, "Eliminado el producto con el id " + id);
                return;
            }
        }
        mensajeErroneoPorDefecto("id ingresado");
    }

    public void actualizarStock(String id, int nuevaCantidad) {
        for (Producto producto : productos) {
            if (producto.getId().equals(id)) {
                producto.setStock(nuevaCantidad);
                UtilsColor.imprimirBloque(ContextColor.WARNING, "Actualizando stock de producto " + producto.getId());
                return;
            }
        }
        mensajeErroneoPorDefecto("id ingresado");
    }

    public void filtrarPorCategoria(CategoriaProducto categoria) {
        for (Producto producto : productos) {
            if (producto.getCategoria().equals(categoria)){
                producto.mostrarInfo();
            }
        }
    }

    public int totalStock() {
        int total = 0;
        for (Producto producto : productos) {
            total+=producto.getStock();
        }
        return total;
    }

    public void productoMayorStock(){
        // Asignamos por defecto el primer producto
        Producto mayor = productos.getFirst();
        for (Producto producto : productos) {
            if (producto.getStock() > mayor.getStock()) {
                mayor = producto;
            }
        }
        UtilsColor.imprimirBloque(ContextColor.INFO, "Producto con mayor Stock ");
        UtilsColor.imprimirBloque(ContextColor.DEFAULT,
                "id: "+mayor.getId()
                +" Nombre: "+mayor.getNombre()
                +" Stock: "+mayor.getStock());
    }

    public void filtroPorPrecio(double precioMin, double precioMax) {
        boolean ocurrencias = false;
        for (Producto producto : productos) {
            if (producto.getPrecio() >= precioMin & producto.getPrecio()<= precioMax) {
                producto.mostrarInfo();
                ocurrencias = true;
            }
        }
        if (!ocurrencias) {
            mensajeErroneoPorDefecto("Rango de precios indicado");
        }
    }

    public void mostrarCategoriasDisponibles() {
        UtilsColor.imprimirBloque(ContextColor.INFO, "Categorias con Stock Disponible");

        // Se utilizará una estructura que NO admite repetidos
        Set<CategoriaProducto> categoriasConStock = new HashSet<>();

        // Recorremos los productos y agregamos sus categorías al Set
        for (Producto producto : productos) {
            if (producto.getStock() > 0) {
                categoriasConStock.add(producto.getCategoria());
            }
        }

        for (CategoriaProducto categoria : categoriasConStock) {
            UtilsColor.imprimirBloque(ContextColor.DEFAULT, categoria.getDescripcion());
        }
    }


    public ArrayList<Producto> getProductos() {
        return productos;
    }

    // Métodos auxiliares
    private void mensajeErroneoPorDefecto(String contexto) {
        UtilsColor.imprimirBloque(ContextColor.ERROR, "No hay coincidencias para el "+contexto);
    }
}