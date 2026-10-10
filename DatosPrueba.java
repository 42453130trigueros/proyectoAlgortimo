import java.io.File;
import java.util.ArrayList;

import datos.ArchivoDat;
import model.*;

/**
 * TEMPORAL: crea clientes y peliculas de prueba en archivos/*.dat para poder
 * probar el CRUD de entradas mientras tus companeros terminan los suyos.
 * - Solo crea un archivo si NO existe (nunca pisa datos reales).
 * - NO subir a Git. Borrar este archivo (y los .dat que creo) cuando ellos terminen.
 */
public class DatosPrueba {

    public static void main(String[] args) {
        if (!new File("archivos/clientes.dat").exists()) {
            ArrayList<Cliente> lista = new ArrayList<>();
            lista.add(new Cliente("C001", "Jose Marin", "av jose galvez 668", 30, "00958550", "M", "Regular"));
            lista.add(new Cliente("C002", "Nancy Muñoz", "av iquitos 1968", 42, "00958550", "F", "Regular"));
            ArchivoDat.guardar("archivos/clientes.dat", lista);
        }
        if (!new File("archivos/clientesPremiun.dat").exists()) {
            ArrayList<ClientePremiun> lista = new ArrayList<>();
            lista.add(new ClientePremiun("C005", "Carla Ruiz", "av iquitos 1968", 35, "00958550", "F",
                    "Acceso a preventas de estrenos"));
            ArchivoDat.guardar("archivos/clientesPremiun.dat", lista);
        }
        if (!new File("archivos/clientesVip.dat").exists()) {
            ArrayList<ClienteVip> lista = new ArrayList<>();
            lista.add(new ClienteVip("C004", "Pedro Torres", "av iquitos 1968", 42, "00958550", "M",
                    "Sala VIP con asientos reclinables"));
            ArchivoDat.guardar("archivos/clientesVip.dat", lista);
        }
        if (!new File("archivos/peliculas.dat").exists()) {
            ArrayList<Pelicula> lista = new ArrayList<>();
            lista.add(new Pelicula("P001", "Titanic", "Drama", "3hrs", "APT", 15.50));
            lista.add(new Pelicula("P002", "Avatar", "Ciencia Ficcion", "3hrs 30min", "+13", 20.00));
            ArchivoDat.guardar("archivos/peliculas.dat", lista);
        }
        if (!new File("archivos/peliculasEstreno.dat").exists()) {
            ArrayList<PeliculaEstreno> lista = new ArrayList<>();
            lista.add(new PeliculaEstreno("P003", "Avengers", "Accion", "2hrs 30min", "+13", 22.00, 5.00));
            ArchivoDat.guardar("archivos/peliculasEstreno.dat", lista);
        }
        if (!new File("archivos/peliculas3D.dat").exists()) {
            ArrayList<Pelicula3D> lista = new ArrayList<>();
            lista.add(new Pelicula3D("P004", "Spiderman", "Accion", "2hrs 30min", "+13", 22.00, 3.00));
            ArchivoDat.guardar("archivos/peliculas3D.dat", lista);
        }
        System.out.println("Datos de prueba listos en la carpeta archivos.");
    }
}
