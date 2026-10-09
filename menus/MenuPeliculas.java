package menus;

/**
 * Gestion de peliculas: primero se elige el TIPO y luego se abre el menu CRUD.
 */
public class MenuPeliculas {

    // Submenu: elegir el tipo
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
                    // TODO: conectar con datos.CrudPeliculas.registrar(tipo)
                    System.out.println("Registrar pelicula " + tipo);
                    break;
                case 2:
                    // TODO: conectar con listar()
                    System.out.println("Listar pelicula " + tipo);
                    break;
                case 3:
                    // TODO: conectar con buscar()
                    System.out.println("Buscar pelicula " + tipo);
                    break;
                case 4:
                    // TODO: conectar con actualizar()
                    System.out.println("Actualizar pelicula " + tipo);
                    break;
                case 5:
                    // TODO: conectar con eliminar()
                    System.out.println("Eliminar pelicula " + tipo);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion invalida, intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
