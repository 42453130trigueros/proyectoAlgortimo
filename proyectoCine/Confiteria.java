public class Confiteria {
    private String CodigoVenta;
    private Cliente cliente;
    private Producto[] productos;
    private int[] cantidades;
    private int totalItems;

    // construtor principal venta vacia , luego se agregan productos 1 o mas
    public Confiteria(String CodigoVenta, Cliente cliente) {
        this.CodigoVenta = CodigoVenta;
        this.cliente = cliente;
        this.productos = new Producto[10]; // Capacidad máxima de 10 productos
        this.cantidades = new int[10]; // Arreglo para almacenar las cantidades correspondientes
        this.totalItems = 0; // Inicialmente no hay productos agregados
    }

    // construtor secundario cuando el cliente compra un producto
    public Confiteria(String CodigoVenta, Cliente cliente, Producto producto, int cantidad) {
        this.CodigoVenta = CodigoVenta;
        this.cliente = cliente;
        this.productos = new Producto[10]; // Capacidad máxima de 10 productos
        this.cantidades = new int[10]; // Arreglo para almacenar las cantidades correspondientes
        this.totalItems = 0; // Inicialmente no hay productos agregados
        agregarProducto(producto, cantidad); // Agregar el producto y la cantidad inicial
    }

    // metedo para agregar productos a la venta
    public void agregarProducto(Producto producto, int cantidad) {
        if (cantidad > 0 && totalItems < productos.length) { // Verificar si hay espacio para agregar más productos
            this.productos[totalItems] = producto;
            this.cantidades[totalItems] = cantidad;
            totalItems++;
        }
    }

    public double calcularSubtotal() {
        double subtotal = 0.0;
        for (int i = 0; i < totalItems; i++) {
            subtotal += productos[i].getPrecioProducto() * cantidades[i];
        }
        return subtotal;
    }

    public double calcularPromocion() {
        double promocion = 0.0;
        for (int i = 0; i < totalItems; i++) {
            promocion += productos[i].getPrecioProducto() * cantidades[i] * productos[i].getPromocion();
        }
        return promocion;
    }

    public double calcularTotal() {
        return calcularSubtotal() - calcularPromocion();
    }

    public void mostrarResumenVenta() {
        System.out.println("Codigo de Venta\t:" + CodigoVenta);
        System.out.println("Cliente\t\t:" + cliente.getDatosCliente());
        System.out.println("Productos Comprados:");
        for (int i = 0; i < totalItems; i++) {
            System.out.println(cantidades[i] + " X " + productos[i].getNombreProducto() + "\tS/. "
                    + productos[i].getPrecioProducto());
        }
        System.out.println("Subtotal\t:S/." + calcularSubtotal());
        System.out.println("Promocion\t:S/." + calcularPromocion());
        System.out.println("Total a Pagar\t:S/." + calcularTotal());
    }

}