public class Dulces extends Producto {
    private String sabor;

    // constructor de la clase Dulces
    public Dulces(String codigoProducto, String nombreProducto, String categoria, double precioProducto, int stock,
            double promocion, String sabor) {
        super(codigoProducto, nombreProducto, categoria, precioProducto, stock, promocion);
        this.sabor = sabor;
    }

    // Getters y Setters
    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    // Sobrescribir el método mostrarProducto para incluir el sabor
    @Override
    public void mostrarProducto() {
        super.mostrarProducto();
        System.out.println("Sabor \t\t\t:" + sabor);
    }
}
