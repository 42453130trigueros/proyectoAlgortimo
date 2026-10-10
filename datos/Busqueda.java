package datos;

import java.util.ArrayList;

import model.Cliente;
import model.Pelicula;

/**
 * Busca un cliente o una pelicula por su codigo en los archivos .dat
 * que guardan los CRUD de tus companeros.
 * Asi CrudEntrada no depende de como esta hecho el CRUD de ellos.
 */
public class Busqueda {

    // Los nombres siguen la plantilla del grupo (CrudClientesVip -> clientesVip.dat).
    // Si un archivo todavia no existe, simplemente se ignora.
    // Cuando tus companeros terminen, confirma que sus nombres coinciden con estos.
    private static final String[] ARCHIVOS_CLIENTES = {
            "archivos/clientes.dat",
            "archivos/clientesRegular.dat",
            "archivos/clientesPremiun.dat",
            "archivos/clientesVip.dat" };

    private static final String[] ARCHIVOS_PELICULAS = {
            "archivos/peliculas.dat",
            "archivos/peliculasEstreno.dat",
            "archivos/peliculasEstrenos.dat",
            "archivos/peliculas3D.dat" };

    // devuelve el cliente, o null si no existe en ningun archivo
    public static Cliente buscarCliente(String codigo) {
        for (int i = 0; i < ARCHIVOS_CLIENTES.length; i++) {
            ArrayList<Cliente> lista = ArchivoDat.cargar(ARCHIVOS_CLIENTES[i]);
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getCodigoCliente().equalsIgnoreCase(codigo)) {
                    return lista.get(j);
                }
            }
        }
        return null;
    }

    // devuelve la pelicula, o null si no existe en ningun archivo
    public static Pelicula buscarPelicula(String codigo) {
        for (int i = 0; i < ARCHIVOS_PELICULAS.length; i++) {
            ArrayList<Pelicula> lista = ArchivoDat.cargar(ARCHIVOS_PELICULAS[i]);
            for (int j = 0; j < lista.size(); j++) {
                if (lista.get(j).getCodigoPelicula().equalsIgnoreCase(codigo)) {
                    return lista.get(j);
                }
            }
        }
        return null;
    }
}
