public class Dulces extends Producto {
    private String sabor;

    public Dulces(String codigoProducto, String nombreProducto, String categoria, double precioProducto, int stock,
            double promocion, String sabor) {
        super(codigoProducto, nombreProducto, categoria, precioProducto, stock, promocion);
        this.sabor = sabor;
    }

    @Override
    public void mostrarProducto() {
        super.mostrarProducto();
        System.out.println("Sabor \t\t:" + sabor);
    }

}
