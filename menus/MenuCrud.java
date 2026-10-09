package menus;

import java.util.Scanner;

/**
 * Menu CRUD reutilizable en todas las gestiones.
 * Devuelve: 1=Registrar 2=Listar 3=Buscar 4=Actualizar 5=Eliminar 0=Regresar
 */
public class MenuCrud {

    // Un solo Scanner compartido por todos los menus
    public static final Scanner teclado = new Scanner(System.in);

    public static int mostrar(String titulo) {
        System.out.println("\n=========================================");
        System.out.println("   " + titulo);
        System.out.println("=========================================");
        System.out.println("1. Registrar");
        System.out.println("2. Listar");
        System.out.println("3. Buscar");
        System.out.println("4. Actualizar");
        System.out.println("5. Eliminar");
        System.out.println("0. Regresar");
        System.out.print("Seleccione una opcion: ");
        int opcion = teclado.nextInt();
        teclado.nextLine(); // consume el Enter para que los CRUD puedan usar nextLine()
        return opcion;
    }
}
