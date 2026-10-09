package model;

import java.io.Serializable;
public class Entrada implements Serializable {
    private static final long serialVersionUID = 1L;

    private Cliente cliente;
    private Pelicula pelicula;
    private int cantidadEntradas;

    // constructor principal
    public Entrada(Cliente cliente, Pelicula pelicula, int cantidadEntradas) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        setCantidadEntradas(cantidadEntradas);

    }

    // constructor secundario 1 entrada por defecto
    public Entrada(Cliente cliente, Pelicula pelicula) {
        this.cliente = cliente;
        this.pelicula = pelicula;
        setCantidadEntradas(1);
    }

    // getters y setters

    public Cliente getCliente() {
        return cliente;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public int getCantidadEntradas() {
        return cantidadEntradas;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    // aca validamos que la cantidad de entradas sea mayor a 0
    public void setCantidadEntradas(int cantidadEntradas) {
        if (cantidadEntradas > 0) {
            this.cantidadEntradas = cantidadEntradas;
        }
    }

    // metodos
    // metodo que las clases va sobreescribir para calcular el subtotal, descuento y
    // total a pagar
    public double calcularRecargoEntrada() {
        return pelicula.getRecargo() * cantidadEntradas;
    }

    public double getSubtotal() {
        return pelicula.getPrecioEntrada() * cantidadEntradas;
    }

    public double getDescuentoAplicado() {
        return cliente.calcularDescuentoCliente(getSubtotal());
    }

    public double getTotalPagar() {
        return getSubtotal() - getDescuentoAplicado() + calcularRecargoEntrada();
    }

    public void mostrarResumenVenta() {
        System.out.println("=======================================================");
        System.out.println("Resumen de Venta");
        System.out.println("=======================================================");
        System.out.println("Cliente \t\t:" + cliente.getDatosCliente());
        System.out.println("Nivel de Membresía \t:" + cliente.getNivelMenbresia());
        System.out.println("Película \t\t:" + pelicula.getTituloPelicula());
        System.out.println("Precio de Entrada \t:S/." + pelicula.getPrecioEntrada());
        System.out.println("Cantidad de Entradas \t:" + cantidadEntradas);
        System.out.println("Subtotal \t\t:S/." + getSubtotal());
        System.out.println("Descuento Aplicado \t:S/." + getDescuentoAplicado());
        System.out.println("Recargo Aplicado \t:S/." + calcularRecargoEntrada());
        System.out.println("Total a Pagar \t\t:S/." + getTotalPagar());
        System.out.println("=======================================================");
        System.out.println("Gracias por su compra, vuelva pronto");
        System.out.println("=======================================================");
        System.out.println("Recargo de Película \t:" + pelicula.getRecargo());
    }

}
