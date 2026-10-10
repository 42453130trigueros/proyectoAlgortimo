package datos;

import java.util.ArrayList;
import java.util.Scanner;

import menus.MenuCrud;
import model.Cliente;
import model.Entrada;
import model.EntradaOnline;
import model.EntradaVip;
import model.Pelicula;

public class CrudEntrada {

    private static Scanner teclado = MenuCrud.teclado;

    // cada tipo se guarda en su propio archivo
    private static String archivo(String tipo) {
        if (tipo.equals("VIP")) {
            return "archivos/entradasVip.dat";
        } else if (tipo.equals("ONLINE")) {
            return "archivos/entradasOnline.dat";
        }
        return "archivos/entradas.dat";
    }

    // CREATE
    public static void registrar(String tipo) {
        ArrayList<Entrada> lista = ArchivoDat.cargar(archivo(tipo));
        System.out.println("\n--- Registrar entrada " + tipo + " ---");

        System.out.print("Codigo del cliente: ");
        Cliente cliente = Busqueda.buscarCliente(teclado.nextLine());
        if (cliente == null) {
            System.out.println("Cliente no encontrado, registrelo primero.");
            return;
        }

        System.out.print("Codigo de la pelicula: ");
        Pelicula pelicula = Busqueda.buscarPelicula(teclado.nextLine());
        if (pelicula == null) {
            System.out.println("Pelicula no encontrada, registrela primero.");
            return;
        }

        System.out.print("Cantidad de entradas: ");
        int cantidad = Integer.parseInt(teclado.nextLine());

        Entrada nueva;
        if (tipo.equals("VIP")) {
            System.out.print("Costo del asiento VIP: ");
            double costo = Double.parseDouble(teclado.nextLine());
            nueva = new EntradaVip(cliente, pelicula, cantidad, costo);
        } else if (tipo.equals("ONLINE")) {
            System.out.print("Cargo por servicio online: ");
            double cargo = Double.parseDouble(teclado.nextLine());
            nueva = new EntradaOnline(cliente, pelicula, cantidad, cargo);
        } else {
            nueva = new Entrada(cliente, pelicula, cantidad);
        }

        lista.add(nueva);
        ArchivoDat.guardar(archivo(tipo), lista);
        System.out.println("Entrada registrada correctamente.");
        nueva.mostrarResumenVenta();
    }

    // READ
    public static void listar(String tipo) {
        ArrayList<Entrada> lista = ArchivoDat.cargar(archivo(tipo));
        System.out.println("\n--- Listado de entradas " + tipo + " ---");

        if (lista.isEmpty()) {
            System.out.println("No hay entradas registradas.");
            return;
        }
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("\nEntrada N° " + (i + 1));
            lista.get(i).mostrarResumenVenta(); // cada tipo muestra lo suyo
        }
    }

    // SEARCH: todas las entradas de un cliente
    public static void buscar(String tipo) {
        ArrayList<Entrada> lista = ArchivoDat.cargar(archivo(tipo));
        System.out.println("\n--- Buscar entradas " + tipo + " ---");

        System.out.print("Codigo del cliente: ");
        String codigo = teclado.nextLine();

        int encontradas = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getCliente().getCodigoCliente().equalsIgnoreCase(codigo)) {
                lista.get(i).mostrarResumenVenta();
                encontradas = encontradas + 1;
            }
        }
        if (encontradas == 0) {
            System.out.println("Ese cliente no tiene entradas " + tipo + ".");
        }
    }

    // UPDATE
    public static void actualizar(String tipo) {
        ArrayList<Entrada> lista = ArchivoDat.cargar(archivo(tipo));
        System.out.println("\n--- Actualizar entrada " + tipo + " ---");

        if (lista.isEmpty()) {
            System.out.println("No hay entradas registradas.");
            return;
        }
        listarCorto(lista);

        System.out.print("Numero de la entrada a actualizar: ");
        int numero = Integer.parseInt(teclado.nextLine());
        if (numero < 1 || numero > lista.size()) {
            System.out.println("Numero no valido.");
            return;
        }
        Entrada entrada = lista.get(numero - 1);

        System.out.print("Nueva cantidad (Enter para mantener " + entrada.getCantidadEntradas() + "): ");
        String texto = teclado.nextLine();
        if (!texto.isEmpty()) {
            entrada.setCantidadEntradas(Integer.parseInt(texto));
        }

        ArchivoDat.guardar(archivo(tipo), lista);
        System.out.println("Entrada actualizada.");
    }

    // DELETE
    public static void eliminar(String tipo) {
        ArrayList<Entrada> lista = ArchivoDat.cargar(archivo(tipo));
        System.out.println("\n--- Eliminar entrada " + tipo + " ---");

        if (lista.isEmpty()) {
            System.out.println("No hay entradas registradas.");
            return;
        }
        listarCorto(lista);

        System.out.print("Numero de la entrada a eliminar: ");
        int numero = Integer.parseInt(teclado.nextLine());
        if (numero < 1 || numero > lista.size()) {
            System.out.println("Numero no valido.");
            return;
        }

        lista.remove(numero - 1);
        ArchivoDat.guardar(archivo(tipo), lista);
        System.out.println("Entrada eliminada.");
    }

    // lista de una linea por entrada, para elegir cual actualizar o eliminar
    private static void listarCorto(ArrayList<Entrada> lista) {
        for (int i = 0; i < lista.size(); i++) {
            Entrada e = lista.get(i);
            System.out.println((i + 1) + ". " + e.getCliente().getDatosCliente()
                    + " | " + e.getPelicula().getTituloPelicula()
                    + " | cantidad: " + e.getCantidadEntradas()
                    + " | total: S/." + e.getTotalPagar());
        }
    }
}
