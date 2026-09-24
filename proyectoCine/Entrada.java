public class Entrada {
    private Cliente cliente;
    private Pelicula pelicula;
    private int cantidadEntradas;
    private double subtotal;
    private double descuentoAplicado;
    private double totalPagar;

    // constructor
    public Entrada(Cliente cliente, Pelicula pelicula, int cantidadEntradas) {
        this.cliente = cliente;
        this.pelicula = pelicula;

        if (cantidadEntradas > 0) {
            this.cantidadEntradas = cantidadEntradas;
        }
        // toma el precio directamente de la pelicula, no como parametro aparte
        this.subtotal = pelicula.getPrecioEntrada() * cantidadEntradas;
        this.descuentoAplicado=cliente.calcularDescuentoCliente(subtotal);
        this.totalPagar = subtotal - descuentoAplicado;
    }

    //metodos
    public void mostrarResumenVenta() {
        System.out.println("==========================================");
        System.out.println("Resumen de Venta");
        System.out.println("==========================================");
        System.out.println("Cliente \t\t:" + cliente.getDatosCliente());
        System.out.println("Nivel de Membresía \t:" + cliente.getNivelMenbresia());
        System.out.println("Película \t\t:" + pelicula.getTituloPelicula());
        System.out.println("Precio de Entrada \t:S/." + pelicula.getPrecioEntrada());
        System.out.println("Cantidad de Entradas \t:" + cantidadEntradas);
        System.out.println("Subtotal \t\t:S/." + subtotal);
        System.out.println("Descuento Aplicado \t:S/." + descuentoAplicado);
        System.out.println("Total a Pagar \t\t:S/." + totalPagar);
    }





}

