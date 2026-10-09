package menus;

import datos.CrudBebidas;
import datos.CrudDulces;
import datos.CrudProductos;

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
                    if (tipo.equals("GENERAL")) {
                        CrudProductos.registrar();
                    } else if (tipo.equals("DULCES")) {
                        CrudDulces.registrar();
                    } else if (tipo.equals("BEBIDA")) {
                        CrudBebidas.registrar();
                    }
                    break;
                case 2:
                    if (tipo.equals("GENERAL")) {
                        CrudProductos.listar();
                    } else if (tipo.equals("DULCES")) {
                        CrudDulces.listar();
                    } else if (tipo.equals("BEBIDA")) {
                        CrudBebidas.listar();
                    }
                    break;
                case 3:
                    if (tipo.equals("GENERAL")) {
                        CrudProductos.buscar();
                    } else if (tipo.equals("DULCES")) {
                        CrudDulces.buscar();
                    } else if (tipo.equals("BEBIDA")) {
                        CrudBebidas.buscar();
                    }
                    break;
                case 4:
                    if (tipo.equals("GENERAL")) {
                        CrudProductos.actualizar();
                    } else if (tipo.equals("DULCES")) {
                        CrudDulces.actualizar();
                    } else if (tipo.equals("BEBIDA")) {
                        CrudBebidas.actualizar();
                    }
                    break;
                case 5:
                    if (tipo.equals("GENERAL")) {
                        CrudProductos.eliminar();
                    } else if (tipo.equals("DULCES")) {
                        CrudDulces.eliminar();
                    } else if (tipo.equals("BEBIDA")) {
                        CrudBebidas.eliminar();
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
