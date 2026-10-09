package datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Lee y guarda listas de objetos en archivos .dat usando serializacion.
 * TODOS los CRUD usan esta misma clase, asi el guardado es igual para todos.
 */
public class ArchivoDat {

    // Si el archivo no existe todavia, devuelve una lista vacia
    @SuppressWarnings("unchecked")
    public static <T> ArrayList<T> cargar(String ruta) {
        File archivo = new File(ruta);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            return (ArrayList<T>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No se pudo leer " + ruta + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Crea la carpeta si hace falta y guarda la lista completa
    public static <T> void guardar(String ruta, ArrayList<T> lista) {
        File archivo = new File(ruta);
        if (archivo.getParentFile() != null) {
            archivo.getParentFile().mkdirs();
        }
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(lista);
        } catch (IOException e) {
            System.out.println("No se pudo guardar " + ruta + ": " + e.getMessage());
        }
    }
}
