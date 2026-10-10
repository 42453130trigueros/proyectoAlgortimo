package menus;

import datos.CrudClientesPremiun;
import datos.CrudClientesRegular;
import datos.CrudClientesVip;

/**
 * Gestion de clientes: primero se elige el TIPO de cliente
 * (Regular, Premium, VIP) y luego se abre el menu CRUD.
 */
public class MenuClientes {

    // Submenu: elegir el tipo de cliente
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
                    if (tipo.equals("REGULAR")) {
                        CrudClientesRegular.registrar();
                    } else if (tipo.equals("PREMIUM")) {
                        CrudClientesPremiun.registrar();
                    } else if (tipo.equals("VIP")) {
                        CrudClientesVip.registrar();
                    }
                    break;
                case 2:
                    if (tipo.equals("REGULAR")) {
                        CrudClientesRegular.listar();
                    } else if (tipo.equals("PREMIUM")) {
                        CrudClientesPremiun.listar();
                    } else if (tipo.equals("VIP")) {
                        CrudClientesVip.listar();
                    }
                    break;
                case 3:
                    if (tipo.equals("REGULAR")) {
                        CrudClientesRegular.buscar();
                    } else if (tipo.equals("PREMIUM")) {
                        CrudClientesPremiun.buscar();
                    } else if (tipo.equals("VIP")) {
                        CrudClientesVip.buscar();
                    }
                    break;
                case 4:
                    if (tipo.equals("REGULAR")) {
                        CrudClientesRegular.actualizar();
                    } else if (tipo.equals("PREMIUM")) {
                        CrudClientesPremiun.actualizar();
                    } else if (tipo.equals("VIP")) {
                        CrudClientesVip.actualizar();
                    }
                    break;
                case 5:
                    if (tipo.equals("REGULAR")) {
                        CrudClientesRegular.eliminar();
                    } else if (tipo.equals("PREMIUM")) {
                        CrudClientesPremiun.eliminar();
                    } else if (tipo.equals("VIP")) {
                        CrudClientesVip.eliminar();
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
