package menus;

/**
 * Gestion de productos: primero se elige el TIPO y luego se abre el menu CRUD.
 */
public class MenuProductos {

    // Submenu: elegir el tipo
    public static void mostrar() {
        int opcion;
        do {
            System.out.println("\n=========================================");
            System.out.println("          GESTION DE PRODUCTOS");
            System.out.println("=========================================");
            System.out.println("1. Producto general");
            System.out.println("2. Dulces");
            System.out.println("3. Bebida");
            System.out.println("0. Regresar");
            System.out.print("Seleccione una opcion: ");
            opcion = MenuCrud.teclado.nextInt();

            switch (opcion) {
                case 1:
                    gestionar("GENERAL");
                    break;
                case 2:
                    gestionar("DULCES");
                    break;
                case 3:
                    gestionar("BEBIDA");
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
            opcion = MenuCrud.mostrar("PRODUCTO " + tipo);

            switch (opcion) {
                case 1:
                    // TODO: conectar con datos.CrudProductos.registrar(tipo)
                    System.out.println("Registrar producto " + tipo);
                    break;
                case 2:
                    // TODO: conectar con listar()
                    System.out.println("Listar producto " + tipo);
                    break;
                case 3:
                    // TODO: conectar con buscar()
                    System.out.println("Buscar producto " + tipo);
                    break;
                case 4:
                    // TODO: conectar con actualizar()
                    System.out.println("Actualizar producto " + tipo);
                    break;
                case 5:
                    // TODO: conectar con eliminar()
                    System.out.println("Eliminar producto " + tipo);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
