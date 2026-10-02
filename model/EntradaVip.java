package model;
public class EntradaVip extends Entrada {
    private double costoAsientoVip;// recargo por cada entrada

    // constructor
    public EntradaVip(Cliente cliente, Pelicula pelicula, int cantidadEntradas, double costoAsientoVip) {
        super(cliente, pelicula, cantidadEntradas);
        if (costoAsientoVip > 0) {
            this.costoAsientoVip = costoAsientoVip;
        }

    }

    public double getCostoAsientoVip() {
        return costoAsientoVip;
    }

    public void setCostoAsientoVip(double costoAsientoVip) {
        this.costoAsientoVip = costoAsientoVip;
    }

    @Override
    public double calcularRecargoEntrada() {
        return super.calcularRecargoEntrada() + (costoAsientoVip * getCantidadEntradas());
    }
    

    @Override
    public void mostrarResumenVenta() {
        System.out.println("***********Entrada VIP***********");
        super.mostrarResumenVenta();
        System.out.println("**********************************");
        System.out.println("Costo Asiento VIP \t:" + costoAsientoVip);
    }

}
