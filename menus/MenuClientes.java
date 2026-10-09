package menus;

/**
 * Gestion de clientes: primero se elige el TIPO y luego se abre el menu CRUD.
 */
public class MenuClientes {

    // Submenu: elegir el tipo
    public static void mostrar() {
        int opcion;
        do {
            System.out.println("\n=========================================");
            System.out.println("          GESTION DE CLIENTES");
            System.out.println("=========================================");
            System.out.println("1. Cliente Regular");
            System.out.println("2. Cliente Premium");
            System.out.println("3. Cliente VIP");
            System.out.println("0. Regresar");
            System.out.print("Seleccione una opcion: ");
            opcion = MenuCrud.teclado.nextInt();

            switch (opcion) {
                case 1:
                    gestionar("REGULAR");
                    break;
                case 2:
                    gestionar("PREMIUM");
                    break;
                case 3:
                    gestionar("VIP");
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
            opcion = MenuCrud.mostrar("CLIENTE " + tipo);

            switch (opcion) {
                case 1:
                    // TODO: conectar con datos.CrudClientes.registrar(tipo)
                    System.out.println("Registrar cliente " + tipo);
                    break;
                case 2:
                    // TODO: conectar con listar()
                    System.out.println("Listar cliente " + tipo);
                    break;
                case 3:
                    // TODO: conectar con buscar()
                    System.out.println("Buscar cliente " + tipo);
                    break;
                case 4:
                    // TODO: conectar con actualizar()
                    System.out.println("Actualizar cliente " + tipo);
                    break;
                case 5:
                    // TODO: conectar con eliminar()
                    System.out.println("Eliminar cliente " + tipo);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
