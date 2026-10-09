import menus.MenuLogin;
import menus.MenuPrincipal;

/**
 * Punto de entrada del programa:
 * 1) pide inicio de sesion
 * 2) si es correcto, muestra el menu principal
 */
public class Main {
    public static void main(String[] args) {
        if (MenuLogin.iniciarSesion()) {
            MenuPrincipal.mostrar();
        }
        System.out.println("Programa finalizado.");
    }
}
