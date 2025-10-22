package fixtures.siststock;

import core.siststock.CategoriaProducto;
import core.siststock.Producto;
import data.DataStore;

public final class StockFixture {
    private StockFixture() { }

    // Producto(String nombre, double precio, int cantidad, CategoriaProducto categoria)
    public static void cargar() {
        DataStore.INVENTARIO.agregarProducto(new Producto("Mate Imperial", 48000, 89, CategoriaProducto.HOGAR));
        DataStore.INVENTARIO.agregarProducto(new Producto("Termo Stanley", 105000, 67,  CategoriaProducto.HOGAR));
        DataStore.INVENTARIO.agregarProducto(new Producto("Yerba mate Playadito", 5000, 200,  CategoriaProducto.ALIMENTOS));
        DataStore.INVENTARIO.agregarProducto(new Producto("Yerba mate Amanda", 4500, 400,  CategoriaProducto.ALIMENTOS));
        DataStore.INVENTARIO.agregarProducto(new Producto("Cargador inalámbrico camping", 70000, 10,  CategoriaProducto.ELECTRONICA));
        DataStore.INVENTARIO.agregarProducto(new Producto("Linterna USB", 15000, 35,  CategoriaProducto.ELECTRONICA));
        DataStore.INVENTARIO.agregarProducto(new Producto("Mameluco para pesca", 120000, 8,  CategoriaProducto.ROPA));
        DataStore.INVENTARIO.agregarProducto(new Producto("Gorro de pesca tradicional", 20000, 22,  CategoriaProducto.ROPA));
    }
}
