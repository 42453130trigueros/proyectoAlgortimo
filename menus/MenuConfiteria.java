package menus;

/**
 * Confiteria NO tiene tipos: va directo al menu CRUD.
 */
public class MenuConfiteria {

    public static void mostrar() {
        int opcion;
        do {
            opcion = MenuCrud.mostrar("VENTAS DE CONFITERIA");

            switch (opcion) {
                case 1:
                    System.out.println("Registrar venta de confiteria");
                    break;
                case 2:
                    System.out.println("Listar ventas de confiteria");
                    break;
                case 3:
                    System.out.println("Buscar venta de confiteria");
                    break;
                case 4:
                    System.out.println("Actualizar venta de confiteria");
                    break;
                case 5:
                    System.out.println("Eliminar venta de confiteria");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
