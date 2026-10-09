package datos;

import java.util.ArrayList;
import java.util.Scanner;
import menus.MenuCrud;
import model.ClienteVip;

/**
 * PLANTILLA de CRUD con serializacion (ejemplo: clientes VIP).
 *
 * Para crear el CRUD de otro tipo:
 *   1) Copia este archivo y cambiale el nombre (ej. CrudPeliculas3D).
 *   2) Cambia ClienteVip por tu clase y el nombre del archivo .dat.
 *   3) Adapta los datos que se piden en registrar() y actualizar().
 *   4) Conectalo en tu menu (reemplaza el System.out.println pendiente).
 * Los nombres de los metodos NO se cambian: registrar, listar, buscar, actualizar, eliminar.
 */
public class CrudClientesVip {

    private static final String ARCHIVO = "archivos/clientesVip.dat";
    private static ArrayList<ClienteVip> lista = ArchivoDat.cargar(ARCHIVO);

    // Scanner compartido con los menus (no crear otro new Scanner(System.in))
    private static Scanner teclado = MenuCrud.teclado;

    // ---------- CRUD ----------
    public static void registrar() {
        System.out.println("--- Registrar cliente VIP ---");
        System.out.print("Codigo: ");
        String codigo = teclado.nextLine();
        if (buscarPorCodigo(codigo) != null) {
            System.out.println("Ya existe un cliente VIP con ese codigo.");
            return;
        }
        System.out.print("Nombres y apellidos: ");
        String nombre = teclado.nextLine();
        System.out.print("Direccion: ");
        String direccion = teclado.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(teclado.nextLine());
        System.out.print("Telefono: ");
        String telefono = teclado.nextLine();
        System.out.print("Sexo (M/F): ");
        String sexo = teclado.nextLine().toUpperCase();
        System.out.print("Servicio exclusivo: ");
        String servicio = teclado.nextLine();

        lista.add(new ClienteVip(codigo, nombre, direccion, edad, telefono, sexo, servicio));
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Cliente VIP registrado.");
    }

    public static void listar() {
        System.out.println("--- Lista de clientes VIP ---");
        if (lista.isEmpty()) {
            System.out.println("No hay clientes VIP registrados.");
            return;
        }
        for (ClienteVip c : lista) {
            c.mostrarCliente();
        }
    }

    public static void buscar() {
        System.out.println("--- Buscar cliente VIP ---");
        System.out.print("Codigo: ");
        ClienteVip c = buscarPorCodigo(teclado.nextLine());
        if (c == null) {
            System.out.println("No se encontro el cliente.");
        } else {
            c.mostrarCliente();
        }
    }

    public static void actualizar() {
        System.out.println("--- Actualizar cliente VIP ---");
        System.out.print("Codigo: ");
        ClienteVip c = buscarPorCodigo(teclado.nextLine());
        if (c == null) {
            System.out.println("No se encontro el cliente.");
            return;
        }
        System.out.println("(Presione Enter para dejar el valor actual)");

        System.out.print("Nombres [" + c.getDatosCliente() + "]: ");
        String nombre = teclado.nextLine();
        if (!nombre.isEmpty()) c.setDatosCliente(nombre);

        System.out.print("Direccion [" + c.getDireccion() + "]: ");
        String direccion = teclado.nextLine();
        if (!direccion.isEmpty()) c.setDireccion(direccion);

        System.out.print("Edad [" + c.getEdad() + "]: ");
        String edad = teclado.nextLine();
        if (!edad.isEmpty()) c.setEdad(Integer.parseInt(edad));

        System.out.print("Telefono [" + c.getTelefono() + "]: ");
        String telefono = teclado.nextLine();
        if (!telefono.isEmpty()) c.setTelefono(telefono);

        System.out.print("Servicio exclusivo [" + c.getServicioExclusivo() + "]: ");
        String servicio = teclado.nextLine();
        if (!servicio.isEmpty()) c.setServicioExclusivo(servicio);

        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Cliente VIP actualizado.");
    }

    public static void eliminar() {
        System.out.println("--- Eliminar cliente VIP ---");
        System.out.print("Codigo: ");
        ClienteVip c = buscarPorCodigo(teclado.nextLine());
        if (c == null) {
            System.out.println("No se encontro el cliente.");
            return;
        }
        lista.remove(c);
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Cliente VIP eliminado.");
    }

    // ---------- busqueda interna ----------
    private static ClienteVip buscarPorCodigo(String codigo) {
        for (ClienteVip c : lista) {
            if (c.getCodigoCliente().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }
}
