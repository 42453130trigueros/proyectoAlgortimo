package datos;

import java.util.ArrayList;
import java.util.Scanner;
import menus.MenuCrud;
import model.Dulces;

/**
 * CRUD de dulce con serializacion (archivo .dat).
 */
public class CrudDulces {

    private static final String ARCHIVO = "archivos/dulces.dat";
    private static ArrayList<Dulces> lista = ArchivoDat.cargar(ARCHIVO);

    // Scanner compartido con los menus (no crear otro new Scanner(System.in))
    private static Scanner teclado = MenuCrud.teclado;

    // ---------- CRUD ----------
    public static void registrar() {
        System.out.println("--- Registrar dulce ---");
        System.out.print("Codigo: ");
        String codigo = teclado.nextLine();
        if (buscarPorCodigo(codigo) != null) {
            System.out.println("Ya existe un dulce con ese codigo.");
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
        System.out.print("Sabor: ");
        String extra = teclado.nextLine();

        lista.add(new Dulces(codigo, nombre, categoria, precio, stock, promocion, extra));
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Dulce registrado.");
    }

    public static void listar() {
        System.out.println("--- Lista de dulces ---");
        if (lista.isEmpty()) {
            System.out.println("No hay dulces registrados.");
            return;
        }
        for (Dulces p : lista) {
            p.mostrarProducto();
        }
    }

    public static void buscar() {
        System.out.println("--- Buscar dulce ---");
        System.out.print("Codigo: ");
        Dulces p = buscarPorCodigo(teclado.nextLine());
        if (p == null) {
            System.out.println("No se encontro el dulce.");
        } else {
            p.mostrarProducto();
        }
    }

    public static void actualizar() {
        System.out.println("--- Actualizar dulce ---");
        System.out.print("Codigo: ");
        Dulces p = buscarPorCodigo(teclado.nextLine());
        if (p == null) {
            System.out.println("No se encontro el dulce.");
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

        System.out.print("Sabor [" + p.getSabor() + "]: ");
        String extra = teclado.nextLine();
        if (!extra.isEmpty()) p.setSabor(extra);

        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Dulce actualizado.");
    }

    public static void eliminar() {
        System.out.println("--- Eliminar dulce ---");
        System.out.print("Codigo: ");
        Dulces p = buscarPorCodigo(teclado.nextLine());
        if (p == null) {
            System.out.println("No se encontro el dulce.");
            return;
        }
        lista.remove(p);
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Dulce eliminado.");
    }

    // ---------- busqueda interna ----------
    private static Dulces buscarPorCodigo(String codigo) {
        for (Dulces p : lista) {
            if (p.getCodigoProducto().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
}
