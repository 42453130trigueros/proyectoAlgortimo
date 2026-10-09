package menus;

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
            System.out.println("2. Entrada VIP");
            System.out.println("3. Entrada Online");
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
                    // TODO: conectar con datos.CrudEntradas.registrar(tipo)
                    System.out.println("Registrar entrada " + tipo);
                    break;
                case 2:
                    // TODO: conectar con listar()
                    System.out.println("Listar entrada " + tipo);
                    break;
                case 3:
                    // TODO: conectar con buscar()
                    System.out.println("Buscar entrada " + tipo);
                    break;
                case 4:
                    // TODO: conectar con actualizar()
                    System.out.println("Actualizar entrada " + tipo);
                    break;
                case 5:
                    // TODO: conectar con eliminar()
                    System.out.println("Eliminar entrada " + tipo);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
