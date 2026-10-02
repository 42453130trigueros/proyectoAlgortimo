public class main {
        public static void main(String[] args) {
                System.out.println("==========================================");
                Cliente cliente1 = new Cliente("C001", "Jose Marin", "av jose galvez 668", 30, "00958550", "M",
                                "Premiun");
                System.out.println("==============Cliente 01==================");
                cliente1.mostrarCliente();

                Cliente cliente2 = new Cliente("C002", "Nancy Muñoz", "av prologacion iquitos 1968", 42, "00958550",
                                "F",
                                "Regular");
                System.out.println("==============Cliente 02==================");
                cliente2.mostrarCliente();

                Cliente cliente3 = new Cliente("C003", "Luis Rojas", "av prologacion iquitos 1968", 42, "00958550", "M",
                                "Regular");
                System.out.println("==============Cliente 03==================");
                cliente3.mostrarCliente();

                System.out.println("==========================================");
                Producto producto1 = new Producto("PR001", "SUBLIME", "CHOCOLATE", 3.50, 1500, 0.25);
                System.out.println("==============Producto 01=================");
                producto1.mostrarProducto();

                Producto producto2 = new Producto("PR002", "COCA-COLA", "BEBIDA", 4.00, 1000, 0);
                System.out.println("==============Producto 02=================");
                producto2.mostrarProducto();

                Dulces producto3 = new Dulces("PR003", "CHOCOLATE", "DULCES", 2.50, 1000, 0.15, "Chocolate");
                System.out.println("==============Producto 03=================");
                producto3.mostrarProducto();

                // Willian Quinto (PELICULAS)

                System.out.println("==========================================");
                Pelicula pelicula1 = new Pelicula("P001", "Titanic", "Drama", "3hrs", "APT", 15.50);
                System.out.println("==============Pelicula 01=================");
                pelicula1.mostrarPelicula();

                Pelicula pelicula2 = new Pelicula("P002", "Avatar", "Ciencia Ficcion", "3hrs 30min", "+13", 20.00);
                System.out.println("==============Pelicula 02=================");
                pelicula2.mostrarPelicula();

                PeliculaEstreno pelicula3 = new PeliculaEstreno("P003", "Avengers", "Accion", "2hrs 30min", "+13",
                                22.00, 5.00);
                System.out.println("==============Pelicula 03=================");
                pelicula3.mostrarPelicula();

                Pelicula3D pelicula4 = new Pelicula3D("P004", "Spiderman", "Accion", "2hrs 30min", "+13", 22.00, 3.00);
                System.out.println("==============Pelicula 04=================");
                pelicula4.mostrarPelicula();

                // Willian Quinto (PELICULAS)

                // leonardo (ENTRADAS)
                System.out.println("=======================================================");
                System.out.println("=======================================================");
                Entrada entrada1 = new Entrada(cliente1, pelicula1, 3);
                entrada1.mostrarResumenVenta();

                Entrada entrada2 = new Entrada(cliente2, pelicula2, 5);
                entrada2.mostrarResumenVenta();

                EntradaVip entrada3 = new EntradaVip(cliente3, pelicula4, 2, 4);
                entrada3.mostrarResumenVenta();

                EntradaOnline entrada4 = new EntradaOnline(cliente1, pelicula3, 2, 1.50);
                entrada4.mostrarResumenVenta();

                Entrada entrada5 = new Entrada(cliente2, pelicula3, 5);
                entrada5.mostrarResumenVenta();

                System.out.println("=======================================================");
                System.out.println("=======================================================");

                // leonardo (ENTRADAS)

                Confiteria venta1 = new Confiteria("V001", cliente1);
                venta1.agregarProducto(producto1, 2); // venta1.totalItems = 1
                venta1.agregarProducto(producto2, 1); // venta1.totalItems = 2
                venta1.agregarProducto(producto3, 4); // venta1.totalItems = 3

                Confiteria venta2 = new Confiteria("V002", cliente2); // venta2.totalItems = 0
                venta2.agregarProducto(producto2, 3); // venta2.totalItems = 1
                System.out.println("=======================================================");
                System.out.println("=======================================================");
                venta1.mostrarResumenVenta();
                System.out.println("=======================================================");
                System.out.println("=======================================================");
                venta2.mostrarResumenVenta();

        }
}
