package menus;

/**
 * Menu principal: desde aqui se entra a cada gestion.
 */
public class MenuPrincipal {

    public static void mostrar() {
        int opcion;
        do {
            System.out.println("\n=========================================");
            System.out.println("            CINE - MENU PRINCIPAL");
            System.out.println("=========================================");
            System.out.println("1. Gestion de clientes");
            System.out.println("2. Gestion de productos");
            System.out.println("3. Gestion de peliculas");
            System.out.println("4. Gestion de entradas");
            System.out.println("5. Gestion de confiteria");
            System.out.println("0. Cerrar sesion");
            System.out.print("Seleccione una opcion: ");
            opcion = MenuCrud.teclado.nextInt();

            switch (opcion) {
                case 1: MenuClientes.mostrar(); break;
                case 2: MenuProductos.mostrar(); break;
                case 3: MenuPeliculas.mostrar(); break;
                case 4: MenuEntradas.mostrar(); break;
                case 5: MenuConfiteria.mostrar(); break;
                case 0:
                    System.out.println("Cerrando sesion...");
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
