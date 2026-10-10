package datos;

import java.util.ArrayList;
import java.util.Scanner;
import menus.MenuCrud;
import model.ClientePremiun;

/**
 * CRUD de clientes Premium con serializacion (archivo .dat).
 */
public class CrudClientesPremiun {

    private static final String ARCHIVO = "archivos/clientesPremiun.dat";
    private static ArrayList<ClientePremiun> lista = ArchivoDat.cargar(ARCHIVO);

    // Scanner compartido con los menus (no crear otro new Scanner(System.in))
    private static Scanner teclado = MenuCrud.teclado;

    // ---------- CRUD ----------
    public static void registrar() {
        System.out.println("--- Registrar cliente Premium ---");
        System.out.print("Codigo: ");
        String codigo = teclado.nextLine();
        if (buscarPorCodigo(codigo) != null) {
            System.out.println("Ya existe un cliente Premium con ese codigo.");
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
        System.out.print("Beneficio exclusivo: ");
        String extra = teclado.nextLine();

        lista.add(new ClientePremiun(codigo, nombre, direccion, edad, telefono, sexo, extra));
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Cliente Premium registrado.");
    }

    public static void listar() {
        System.out.println("--- Lista de clientes Premium ---");
        if (lista.isEmpty()) {
            System.out.println("No hay clientes Premium registrados.");
            return;
        }
        for (ClientePremiun c : lista) {
            c.mostrarCliente();
        }
    }

    public static void buscar() {
        System.out.println("--- Buscar cliente Premium ---");
        System.out.print("Codigo: ");
        ClientePremiun c = buscarPorCodigo(teclado.nextLine());
        if (c == null) {
            System.out.println("No se encontro el cliente.");
        } else {
            c.mostrarCliente();
        }
    }

    public static void actualizar() {
        System.out.println("--- Actualizar cliente Premium ---");
        System.out.print("Codigo: ");
        ClientePremiun c = buscarPorCodigo(teclado.nextLine());
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

        System.out.print("Beneficio exclusivo [" + c.getBeneficioExclusivo() + "]: ");
        String extra = teclado.nextLine();
        if (!extra.isEmpty()) c.setBeneficioExclusivo(extra);

        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Cliente Premium actualizado.");
    }

    public static void eliminar() {
        System.out.println("--- Eliminar cliente Premium ---");
        System.out.print("Codigo: ");
        ClientePremiun c = buscarPorCodigo(teclado.nextLine());
        if (c == null) {
            System.out.println("No se encontro el cliente.");
            return;
        }
        lista.remove(c);
        ArchivoDat.guardar(ARCHIVO, lista);
        System.out.println("Cliente Premium eliminado.");
    }

    // ---------- busqueda interna ----------
    private static ClientePremiun buscarPorCodigo(String codigo) {
        for (ClientePremiun c : lista) {
            if (c.getCodigoCliente().equalsIgnoreCase(codigo)) {
                return c;
            }
        }
        return null;
    }
}
