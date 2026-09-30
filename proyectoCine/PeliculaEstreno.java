public class PeliculaEstreno extends Pelicula {
    private double recargo;

    public PeliculaEstreno(String codigoPelicula, String tituloPelicula, String genero, String duracion,
            String clasificacion, double precioEntrada, double recargo) {
        super(codigoPelicula, tituloPelicula, genero, duracion, clasificacion, precioEntrada);
        this.recargo = recargo;
    }

    @Override
    public void mostrarPelicula() {
        super.mostrarPelicula();
        System.out.println("Recargo \t\t:" + recargo);
    }

}
