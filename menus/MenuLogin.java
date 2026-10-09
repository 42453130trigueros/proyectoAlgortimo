package menus;

import java.util.Scanner;

public class MenuLogin {
    private static final String CORREO_ADMIN = "admin";
    private static final String CLAVE_ADMIN = "admin";
    private static final int MAX_INTENTOS = 3;

    // Devuelve true si el login fue correcto, false si se agotaron los intentos
    public static boolean iniciarSesion() {
        System.out.println("=========================================");
        System.out.println("            INICIO DE SESION");
        System.out.println("=========================================");
        Scanner teclado = new Scanner(System.in);

        for (int intento = 1; intento <= MAX_INTENTOS; intento++) {
            // String correo = Consola.leerTexto("Correo: ");
            // String clave = Consola.leerTexto("Clave : ");

            System.out.print("Ingresar Correo :");
            String correo = teclado.nextLine();
            System.out.print("Ingresar Clave :");
            String clave = teclado.nextLine();
            if (correo.equalsIgnoreCase(CORREO_ADMIN) && clave.equals(CLAVE_ADMIN)) {
                System.out.println("\nBienvenido, Administrador.");
                return true;
            }
            System.out.println("Correo o clave incorrectos (intento " + intento + " de " + MAX_INTENTOS + ")\n");
        }

        System.out.println("Demasiados intentos fallidos.");
        return false;
    }
}
