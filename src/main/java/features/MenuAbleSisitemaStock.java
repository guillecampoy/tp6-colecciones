package features;

import core.SubMenu;
import core.siststock.CategoriaProducto;
import core.siststock.Producto;
import data.DataStore;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuAbleSisitemaStock extends SubMenu {

    public MenuAbleSisitemaStock(String titulo) {
        super(titulo);
    }

    @Override
    protected void imprimirOpciones() {
        System.out.println("1.  Agregar producto");
        System.out.println("2.  Listar productos");
        System.out.println("3.  Buscar producto por ID");
        System.out.println("4.  Eliminar producto por ID");
        System.out.println("5.  Actualizar stock");
        System.out.println("6.  Filtro por categoría");
        System.out.println("7.  Total de stock");
        System.out.println("8.  Producto con mayor stock");
        System.out.println("9.  Filtrado por precio");
        System.out.println("10. Listar categorías disponibles");
        System.out.println("11. Cargar datos de prueba");
        System.out.println("0.  Volver");
    }

    @Override
    protected boolean resolverOpcion(int opcion) {
        switch (opcion) {
            case 1 -> agregarProducto();
            case 2 -> listarProductos();
            case 3 -> buscarProducto();
            case 4 -> eliminarProducto();
            case 5 -> actualizacionStock();
            case 6 -> filtroPorCategoria();
            case 7 -> totalStock();
            case 8 -> mayorStock();
            case 9 -> filtroProductoRangoPrecios();
            case 10 -> categoriasDisponibles();
            case 11 -> cargarDemo();
            default -> { return false; }
        }
        return true;
    }

    private void agregarProducto() {
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.print("Cantidad: ");
        int cantidad = Integer.parseInt(scanner.nextLine());
        CategoriaProducto categoria = leerCategoriaValida();
        DataStore.INVENTARIO.agregarProducto(new Producto(nombre, precio,cantidad, categoria));
        System.out.println("→ Producto agregado.");
    }

    private void listarProductos() {
        if (DataStore.INVENTARIO.getProductos().isEmpty()) {
            System.out.println("(Sin productos)");
            return;
        }
        DataStore.INVENTARIO.listarProductos();
    }

    private void buscarProducto() {
        System.out.print("Ingrese el ID del producto: ");
        String idProducto = scanner.nextLine().trim().toUpperCase();
        DataStore.INVENTARIO.buscarProductoPorId(idProducto);
    }

    private void eliminarProducto() {
        System.out.print("Ingrese el ID del producto: ");
        String idProducto = scanner.nextLine().trim().toUpperCase();
        DataStore.INVENTARIO.eliminarProductoPorId(idProducto);
    }

    private void actualizacionStock() {
        System.out.print("Ingrese el ID del producto: ");
        String idProducto = scanner.nextLine().trim().toUpperCase();
        System.out.print("Ingrese el nuevo stock del producto: ");
        int cantidad = scanner.nextInt();
        DataStore.INVENTARIO.actualizarStock(idProducto, cantidad);
    }

    private void filtroPorCategoria() {
        System.out.print("Ingrese la categoría para filtrar: ");
        CategoriaProducto categoria = leerCategoriaValida();
        DataStore.INVENTARIO.filtrarPorCategoria(categoria);
    }

    private void totalStock() {
        int stock =  DataStore.INVENTARIO.totalStock();
        System.out.println("Total de stock en el inventario: " + stock);
    }

    private void mayorStock() {
        DataStore.INVENTARIO.productoMayorStock();
    }

    private void filtroProductoRangoPrecios() {
        System.out.println("Ingrese rango de precios:");
        System.out.print("Ingrese el valor MINIMO: ");
        double precioMin = scanner.nextDouble();
        System.out.print("Ingrese el valor MAXIMO: ");
        double precioMax = scanner.nextDouble();
        DataStore.INVENTARIO.filtroPorPrecio(precioMin, precioMax);
    }

    private void categoriasDisponibles() {
        System.out.println("Listado de categorias disponibles:");
        DataStore.INVENTARIO.mostrarCategoriasDisponibles();
    }

    private void cargarDemo() {
        fixtures.siststock.StockFixture.cargar();
        System.out.println("→ Datos de stock de ejemplo cargados.");
    }


    // métodos para soporte en operaciones necesarias en menú
    private static CategoriaProducto leerCategoriaValida() {
        ArrayList<Integer> categorias = new ArrayList<>(Arrays.asList(0, 1, 2, 3));
        System.out.print("Categoria: (0-Alimento, 1-Electronica, 2-Ropa, 3-Hogar)");
        int categoria = scanner.nextInt();
        while (!(categorias.contains(categoria))) {
            System.out.print("Categoria inválida");
            System.out.print("Categoria: (0-Alimento, 1-Electronica, 2-Ropa, 3-Hogar)");
            categoria = scanner.nextInt();
        }
        return CategoriaProducto.values()[categoria];
    }
}
