package model;
public class Pelicula3D extends Pelicula {
    private double recargoLentes;

    public Pelicula3D(String codigoPelicula, String tituloPelicula, String genero, String duracion,
            String clasificacion, double precioEntrada, double recargoLentes) {
        super(codigoPelicula, tituloPelicula, genero, duracion, clasificacion, precioEntrada);
        if (recargoLentes > 0) {
            this.recargoLentes = recargoLentes;
        }

    }

    @Override
    public double getRecargo() {
        return recargoLentes;
    }

    public void setRecargo(double recargoLentes) {
        this.recargoLentes = recargoLentes;
    }

    @Override
    public void mostrarPelicula() {
        super.mostrarPelicula();
        System.out.println("Recargo \t\t:" + recargoLentes);
    }
    
}
