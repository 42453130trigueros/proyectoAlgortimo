public class Confiteria {
    private String CodigoVenta;
    private Cliente cliente;
    private Producto producto;
    private int cantidadProducto;

    // constructor principal
    public Confiteria(String CodigoVenta, Cliente cliente, Producto producto, int cantidadProducto) {
        this.CodigoVenta = CodigoVenta;
        this.cliente = cliente;
        this.producto = producto;
        if (cantidadProducto > 0) {
            this.cantidadProducto = cantidadProducto;
        }
    }

    // getters y setters
    public String getCodigoVenta() {
        return CodigoVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCodigoVenta(String CodigoVenta) {
        this.CodigoVenta = CodigoVenta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    // metodos

    public double calcularSubtotal() {
        return producto.getPrecioProducto() * cantidadProducto;
    }

    public double calcularPromocion() {
        return producto.getPromocion() * calcularSubtotal();
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularPromocion();
    }

    public void mostrarResumenVenta() {
        System.out.println("Codigo de venta \t:" + CodigoVenta);
        System.out.println("Cliente \t\t:" + cliente.getDatosCliente());
        System.out.println("Producto \t\t:" + producto.getNombreProducto());
        System.out.println("Cantidad de productos \t:" + cantidadProducto);
        System.out.println("Precio unitario \t:S/." + producto.getPrecioProducto());
        System.out.println("Subtotal \t\t:S/." + calcularSubtotal());
        System.out.println("Promoción \t\t:S/." + calcularPromocion());
        System.out.println("Total a pagar \t\t:S/." + calcularTotal());
    }

}