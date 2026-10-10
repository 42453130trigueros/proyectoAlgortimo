package menus;

import datos.CrudEntrada;

/**
 * Gestion de entradas: primero se elige el TIPO y luego se abre el menu CRUD.
 */
public class MenuEntradas {

    // Submenu: elegir el tipo
    public static void mostrar() {
        int opcion;
        do {
            System.out.println("\n=========================================");
            System.out.println("          GESTION DE ENTRADAS");
            System.out.println("=========================================");
            System.out.println("1. Entrada normal");
            System.out.println("2. Entrada con asiento VIP");
            System.out.println("3. Entrada comprada online");
            System.out.println("0. Regresar");
            System.out.print("Seleccione una opcion: ");
            opcion = MenuCrud.teclado.nextInt();

            switch (opcion) {
                case 1:
                    gestionar("NORMAL");
                    break;
                case 2:
                    gestionar("VIP");
                    break;
                case 3:
                    gestionar("ONLINE");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 0);
    }

    // Menu CRUD del tipo elegido
    private static void gestionar(String tipo) {
        int opcion;
        do {
            opcion = MenuCrud.mostrar("ENTRADA " + tipo);

            switch (opcion) {
                case 1:
                    CrudEntrada.registrar(tipo);
                    break;
                case 2:
                    CrudEntrada.listar(tipo);
                    break;
                case 3:
                    CrudEntrada.buscar(tipo);
                    break;
                case 4:
                    CrudEntrada.actualizar(tipo);
                    break;
                case 5:
                    CrudEntrada.eliminar(tipo);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
