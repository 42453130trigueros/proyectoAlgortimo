package menus;

import datos.CrudPeliculas;
import datos.CrudPeliculas3D;
import datos.CrudPeliculasEstreno;

/**
 * Gestion de peliculas: primero se elige el TIPO de pelicula
 * (Normal, Estreno, 3D) y luego se abre el menu CRUD.
 */
public class MenuPeliculas {

    // Submenu: elegir el tipo de pelicula
    public static void mostrar() {
        int opcion;
        do {
            System.out.println("\n=========================================");
            System.out.println("          GESTION DE PELICULAS");
            System.out.println("=========================================");
            System.out.println("1. Pelicula normal");
            System.out.println("2. Pelicula de estreno");
            System.out.println("3. Pelicula 3D");
            System.out.println("0. Regresar");
            System.out.print("Seleccione una opcion: ");
            opcion = MenuCrud.teclado.nextInt();

            switch (opcion) {
                case 1:
                    gestionar("NORMAL");
                    break;
                case 2:
                    gestionar("ESTRENO");
                    break;
                case 3:
                    gestionar("3D");
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
            opcion = MenuCrud.mostrar("PELICULA " + tipo);

            switch (opcion) {
                case 1:
                    if (tipo.equals("NORMAL")) {
                        CrudPeliculas.registrar();
                    } else if (tipo.equals("ESTRENO")) {
                        CrudPeliculasEstreno.registrar();
                    } else if (tipo.equals("3D")) {
                        CrudPeliculas3D.registrar();
                    }
                    break;
                case 2:
                    if (tipo.equals("NORMAL")) {
                        CrudPeliculas.listar();
                    } else if (tipo.equals("ESTRENO")) {
                        CrudPeliculasEstreno.listar();
                    } else if (tipo.equals("3D")) {
                        CrudPeliculas3D.listar();
                    }
                    break;
                case 3:
                    if (tipo.equals("NORMAL")) {
                        CrudPeliculas.buscar();
                    } else if (tipo.equals("ESTRENO")) {
                        CrudPeliculasEstreno.buscar();
                    } else if (tipo.equals("3D")) {
                        CrudPeliculas3D.buscar();
                    }
                    break;
                case 4:
                    if (tipo.equals("NORMAL")) {
                        CrudPeliculas.actualizar();
                    } else if (tipo.equals("ESTRENO")) {
                        CrudPeliculasEstreno.actualizar();
                    } else if (tipo.equals("3D")) {
                        CrudPeliculas3D.actualizar();
                    }
                    break;
                case 5:
                    if (tipo.equals("NORMAL")) {
                        CrudPeliculas.eliminar();
                    } else if (tipo.equals("ESTRENO")) {
                        CrudPeliculasEstreno.eliminar();
                    } else if (tipo.equals("3D")) {
                        CrudPeliculas3D.eliminar();
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
