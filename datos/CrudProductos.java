package datos;

import java.util.ArrayList;
import java.util.Scanner;
import menus.MenuCrud;
import model.Producto;

/**
 * CRUD de producto general con serializacion (archivo .dat).
 */
public class CrudProductos {

    private static final String ARCHIVO = "archivos/productos.dat";
    private static ArrayList<Producto> lista = ArchivoDat.cargar(ARCHIVO);

    // Scanner compartido con los menus (no crear otro new Scanner(System.in))
    private static Scanner teclado = MenuCrud.teclado;

    // ---------- CRUD ----------
    public static void registrar() {
        System.out.println("--- Registrar producto general ---");
        System.out.print("Codigo: ");
        String codigo = teclado.nextLine();
        if (buscarPorCodigo(codigo) != null) {
            System.out.println("Ya existe un producto general con ese codigo.");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = teclado.nextLine();
        System.out.print("Categoria: ");
        String categoria = teclado.nextLine();
        System.out.print("Precio: ");
        double precio = Double.parseDouble(teclado.nextLine());
        System.out.print("Stock: ");
        int stock = Integer.parseInt(teclado.nextLine());
        System.out.print("Promocion (ej. 0.10 = 10%): ");
        double promocion = Double.parseDouble(teclado.nextLine());

        lista.add(new Producto(codigo, nombre, categoria, precio, stock, promocion));
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Producto general registrado.");
    }

    public static void listar() {
        System.out.println("--- Lista de productos generales ---");
        if (lista.isEmpty()) {
            System.out.println("No hay productos generales registrados.");
            return;
        }
        for (Producto p : lista) {
            p.mostrarProducto();
        }
    }

    public static void buscar() {
        System.out.println("--- Buscar producto general ---");
        System.out.print("Codigo: ");
        Producto p = buscarPorCodigo(teclado.nextLine());
        if (p == null) {
            System.out.println("No se encontro el producto general.");
        } else {
            p.mostrarProducto();
        }
    }

    public static void actualizar() {
        System.out.println("--- Actualizar producto general ---");
        System.out.print("Codigo: ");
        Producto p = buscarPorCodigo(teclado.nextLine());
        if (p == null) {
            System.out.println("No se encontro el producto general.");
            return;
        }
        System.out.println("(Presione Enter para dejar el valor actual)");

        System.out.print("Nombre [" + p.getNombreProducto() + "]: ");
        String nombre = teclado.nextLine();
        if (!nombre.isEmpty()) p.setNombreProducto(nombre);

        System.out.print("Categoria [" + p.getCategoria() + "]: ");
        String categoria = teclado.nextLine();
        if (!categoria.isEmpty()) p.setCategoria(categoria);

        System.out.print("Precio [" + p.getPrecioProducto() + "]: ");
        String precio = teclado.nextLine();
        if (!precio.isEmpty()) p.setPrecioProducto(Double.parseDouble(precio));

        System.out.print("Stock [" + p.getStock() + "]: ");
        String stock = teclado.nextLine();
        if (!stock.isEmpty()) p.setStock(Integer.parseInt(stock));

        System.out.print("Promocion [" + p.getPromocion() + "]: ");
        String promocion = teclado.nextLine();
        if (!promocion.isEmpty()) p.setPromocion(Double.parseDouble(promocion));

        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Producto general actualizado.");
    }

    public static void eliminar() {
        System.out.println("--- Eliminar producto general ---");
        System.out.print("Codigo: ");
        Producto p = buscarPorCodigo(teclado.nextLine());
        if (p == null) {
            System.out.println("No se encontro el producto general.");
            return;
        }
        lista.remove(p);
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Producto general eliminado.");
    }

    // ---------- busqueda interna ----------
    private static Producto buscarPorCodigo(String codigo) {
        for (Producto p : lista) {
            if (p.getCodigoProducto().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
}
