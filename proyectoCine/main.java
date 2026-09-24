public class main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        Cliente cliente1 = new Cliente("C001", "Jose Marin", "av jose galvez 668", 30, "00958550", "M", "Premiun");
        System.out.println("==============Cliente 01==================");
        cliente1.mostrarCliente();

        Cliente cliente2 = new Cliente("C002", "Nancy Muñoz", "av prologacion iquitos 1968", 42, "00958550", "F",
                "Regular");
        System.out.println("==============Cliente 02==================");
        cliente2.mostrarCliente();

        System.out.println("==========================================");
        Producto producto1 = new Producto("PR001", "SUBLIME", "CHOCOLATE", 3.50, 1500, 0.25);
        System.out.println("==============Producto 01=================");
        producto1.mostrarProducto();

        System.out.println("==========================================");
        Pelicula pelicula1 = new Pelicula("P001", "Titanic", "Drama", "3hrs", "APT", 15.50);
        System.out.println("==============Pelicula 01=================");
        pelicula1.mostrarPelicula();

        Pelicula pelicula2 = new Pelicula("P002", "Avatar", "Ciencia Ficcion", "3hrs 30min", "+13", 20.00);
        System.out.println("==============Pelicula 02=================");
        pelicula2.mostrarPelicula();

        Entrada entrada1 = new Entrada(cliente1, pelicula1, 3);
        entrada1.mostrarResumenVenta();

        Entrada entrada2 = new Entrada(cliente2, pelicula2, 5);
        entrada2.mostrarResumenVenta();

    }
}
