package datos;

import java.util.ArrayList;
import java.util.Scanner;
import menus.MenuCrud;
import model.PeliculaEstreno;

/**
 * CRUD de peliculas de estreno con serializacion (archivo .dat).
 */
public class CrudPeliculasEstreno {

    private static final String ARCHIVO = "archivos/peliculasEstrenos.dat";
    private static ArrayList<PeliculaEstreno> lista = ArchivoDat.cargar(ARCHIVO);

    // Scanner compartido con los menus (no crear otro new Scanner(System.in))
    private static Scanner teclado = MenuCrud.teclado;

    // ---------- CRUD ----------
    public static void registrar() {
        System.out.println("--- Registrar pelicula de estreno ---");
        System.out.print("Codigo: ");
        String codigo = teclado.nextLine();
        if (buscarPorCodigo(codigo) != null) {
            System.out.println("Ya existe una pelicula de estreno con ese codigo.");
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
        System.out.print("Recargo de estreno: ");
        double recargo = Double.parseDouble(teclado.nextLine());

        lista.add(new PeliculaEstreno(codigo, titulo, genero, duracion, clasificacion, precio, recargo));
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Pelicula registrada.");
    }

    public static void listar() {
        System.out.println("--- Lista de peliculas de estreno ---");
        if (lista.isEmpty()) {
            System.out.println("No hay peliculas de estreno registradas.");
            return;
        }
        for (PeliculaEstreno p : lista) {
            p.mostrarPelicula();
        }
    }

    public static void buscar() {
        System.out.println("--- Buscar pelicula de estreno ---");
        System.out.print("Codigo: ");
        PeliculaEstreno p = buscarPorCodigo(teclado.nextLine());
        if (p == null) {
            System.out.println("No se encontro la pelicula.");
        } else {
            p.mostrarPelicula();
        }
    }

    public static void actualizar() {
        System.out.println("--- Actualizar pelicula de estreno ---");
        System.out.print("Codigo: ");
        PeliculaEstreno p = buscarPorCodigo(teclado.nextLine());
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

        System.out.print("Recargo de estreno [" + p.getRecargo() + "]: ");
        String recargo = teclado.nextLine();
        if (!recargo.isEmpty()) p.setRecargo(Double.parseDouble(recargo));

        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Pelicula actualizada.");
    }

    public static void eliminar() {
        System.out.println("--- Eliminar pelicula de estreno ---");
        System.out.print("Codigo: ");
        PeliculaEstreno p = buscarPorCodigo(teclado.nextLine());
        if (p == null) {
            System.out.println("No se encontro la pelicula.");
            return;
        }
        lista.remove(p);
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Pelicula eliminada.");
    }

    // ---------- busqueda interna ----------
    private static PeliculaEstreno buscarPorCodigo(String codigo) {
        for (PeliculaEstreno p : lista) {
            if (p.getCodigoPelicula().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
}
