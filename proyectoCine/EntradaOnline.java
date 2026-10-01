public class EntradaOnline extends Entrada {
    private double cargoServicioOnline;// cargo fijo por la compra de entradas online

    public EntradaOnline(Cliente cliente, Pelicula pelicula, int cantidadEntradas, double cargoServicioOnline) {
        super(cliente, pelicula, cantidadEntradas);
        if (cargoServicioOnline > 0) {
            this.cargoServicioOnline = cargoServicioOnline;
        }
        
    }

    public double getCargoServicioOnline() {
        return cargoServicioOnline;
    }

    public void setCargoServicioOnline(double cargoServicioOnline) {
        this.cargoServicioOnline = cargoServicioOnline;
    }

    @Override
    public double calcularRecargoEntrada() {
        return super.calcularRecargoEntrada() + cargoServicioOnline;
    }

    @Override 
    public void mostrarResumenVenta() {
        System.out.println("***********Entrada Online***********");
        super.mostrarResumenVenta();
        System.out.println("**********************************");
        System.out.println("Cargo Servicio Online \t:" + cargoServicioOnline);  
        
    }
}
