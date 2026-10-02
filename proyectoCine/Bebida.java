public class Bebida extends Producto {
    private int tamano; // Tamaño de la bebida en litros

    // Constructor de la clase Bebida
    public Bebida(String codigoProducto, String nombreProducto, String categoria, double precioProducto, int stock,
            double promocion, int tamano) {
        super(codigoProducto, nombreProducto, categoria, precioProducto, stock, promocion);
        this.tamano = tamano;
    }

    // Getters y Setters
    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    // Sobrescribir el método mostrarProducto para incluir el tamaño
    @Override
    public void mostrarProducto() {
        super.mostrarProducto();
        System.out.println("Tamaño \t\t\t:" + tamano + " litros");
    }
}