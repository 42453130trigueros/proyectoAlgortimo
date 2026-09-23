public class Pelicula {
    private String tituloPelicula;
    private String genero;
    private String duracion;
    private String clasificacion;
    private double precioEntrada;

    // contructor
    public Pelicula(String tituloPelicula, String genero, String duracion, String clasificacion, double precioEntrada) {
        this.tituloPelicula = tituloPelicula;
        this.genero = genero;
        this.duracion = duracion;

        if (clasificacion == "APT" || clasificacion == "+18" || clasificacion == "+13") {
            this.clasificacion = clasificacion;
        }

        if (precioEntrada > 0) {
            this.precioEntrada = precioEntrada;
        }

    }

    // getters
    public String getTituloPelicula() {
        return tituloPelicula;
    }

    public String getGenero() {
        return genero;
    }

    public String getDuracion() {
        return duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    // setters
    public void setTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    // metodo sin parametros
    void mostrarPelicula() {
        System.out.println("==========================================");
        System.out.println("Titulo de Pelicula \t:" + tituloPelicula);
        System.out.println("Genero \t\t\t:" + genero);
        System.out.println("Duracion  \t\t:" + duracion);
        System.out.println("Clasificacion  \t\t:" + clasificacion);
        System.out.println("Precio de Entrada \t:" + precioEntrada);
        
    }
}
