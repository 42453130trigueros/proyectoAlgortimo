package datos;

import java.util.ArrayList;
import java.util.Scanner;
import menus.MenuCrud;
import model.Pelicula3D;

/**
 * CRUD de peliculas 3D con serializacion (archivo .dat).
 */
public class CrudPeliculas3D {

    private static final String ARCHIVO = "archivos/peliculas3D.dat";
    private static ArrayList<Pelicula3D> lista = ArchivoDat.cargar(ARCHIVO);

    // Scanner compartido con los menus (no crear otro new Scanner(System.in))
    private static Scanner teclado = MenuCrud.teclado;

    // ---------- CRUD ----------
    public static void registrar() {
        System.out.println("--- Registrar pelicula 3D ---");
        System.out.print("Codigo: ");
        String codigo = teclado.nextLine();
        if (buscarPorCodigo(codigo) != null) {
            System.out.println("Ya existe una pelicula 3D con ese codigo.");
            return;
        }
        System.out.print("Titulo: ");
        String titulo = teclado.nextLine();
        System.out.print("Genero: ");
        String genero = teclado.nextLine();
        System.out.print("Duracion: ");
        String duracion = teclado.nextLine();
        System.out.print("Clasificacion (APT, +13, +18): ");
        String clasificacion = teclado.nextLine();
        System.out.print("Precio de entrada: ");
        double precio = Double.parseDouble(teclado.nextLine());
        System.out.print("Recargo de lentes 3D: ");
        double recargo = Double.parseDouble(teclado.nextLine());

        lista.add(new Pelicula3D(codigo, titulo, genero, duracion, clasificacion, precio, recargo));
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Pelicula registrada.");
    }

    public static void listar() {
        System.out.println("--- Lista de peliculas 3D ---");
        if (lista.isEmpty()) {
            System.out.println("No hay peliculas 3D registradas.");
            return;
        }
        for (Pelicula3D p : lista) {
            p.mostrarPelicula();
        }
    }

    public static void buscar() {
        System.out.println("--- Buscar pelicula 3D ---");
        System.out.print("Codigo: ");
        Pelicula3D p = buscarPorCodigo(teclado.nextLine());
        if (p == null) {
            System.out.println("No se encontro la pelicula.");
        } else {
            p.mostrarPelicula();
        }
    }

    public static void actualizar() {
        System.out.println("--- Actualizar pelicula 3D ---");
        System.out.print("Codigo: ");
        Pelicula3D p = buscarPorCodigo(teclado.nextLine());
        if (p == null) {
            System.out.println("No se encontro la pelicula.");
            return;
        }
        System.out.println("(Presione Enter para dejar el valor actual)");

        System.out.print("Titulo [" + p.getTituloPelicula() + "]: ");
        String titulo = teclado.nextLine();
        if (!titulo.isEmpty()) p.setTituloPelicula(titulo);

        System.out.print("Genero [" + p.getGenero() + "]: ");
        String genero = teclado.nextLine();
        if (!genero.isEmpty()) p.setGenero(genero);

        System.out.print("Duracion [" + p.getDuracion() + "]: ");
        String duracion = teclado.nextLine();
        if (!duracion.isEmpty()) p.setDuracion(duracion);

        System.out.print("Clasificacion [" + p.getClasificacion() + "]: ");
        String clasificacion = teclado.nextLine();
        if (!clasificacion.isEmpty()) p.setClasificacion(clasificacion);

        System.out.print("Precio de entrada [" + p.getPrecioEntrada() + "]: ");
        String precio = teclado.nextLine();
        if (!precio.isEmpty()) p.setPrecioEntrada(Double.parseDouble(precio));

        System.out.print("Recargo de lentes 3D [" + p.getRecargo() + "]: ");
        String recargo = teclado.nextLine();
        if (!recargo.isEmpty()) p.setRecargo(Double.parseDouble(recargo));

        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Pelicula actualizada.");
    }

    public static void eliminar() {
        System.out.println("--- Eliminar pelicula 3D ---");
        System.out.print("Codigo: ");
        Pelicula3D p = buscarPorCodigo(teclado.nextLine());
        if (p == null) {
            System.out.println("No se encontro la pelicula.");
            return;
        }
        lista.remove(p);
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Pelicula eliminada.");
    }

    // ---------- busqueda interna ----------
    private static Pelicula3D buscarPorCodigo(String codigo) {
        for (Pelicula3D p : lista) {
            if (p.getCodigoPelicula().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
}
