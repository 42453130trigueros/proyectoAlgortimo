import model.*;

public class main {
        public static void main(String[] args) {

                System.out.println("=======================================================");
                System.out.println("============REGISTRO CLIENTES==========================");
                System.out.println("=======================================================");

                Cliente cliente1 = new Cliente("C001", "Jose Marin", "av jose galvez 668", 30, "00958550", "M",
                                "Regular");
                Cliente cliente2 = new Cliente("C002", "Nancy Muñoz", "av prologacion iquitos 1968", 42, "00958550",
                                "F",
                                "Regular");
                Cliente cliente3 = new Cliente("C003", "Luis Rojas", "av prologacion iquitos 1968", 42, "00958550", "M",
                                "Regular");
                ClienteVip cliente4 = new ClienteVip("C004", "Pedro Torres", "av prologacion iquitos 1968", 42,
                                "00958550", "M", "Sala VIP con asientos reclinables");
                ClientePremiun cliente5 = new ClientePremiun("C005", "Carla Ruiz", "av prologacion iquitos 1968", 35,
                                "00958550", "F", "Acceso a preventas de estrenos");

                System.out.println("====================Cliente 01=========================");
                cliente1.mostrarCliente();
                System.out.println("====================Cliente 02=========================");
                cliente2.mostrarCliente();
                System.out.println("====================Cliente 03=========================");
                cliente3.mostrarCliente();
                System.out.println("====================Cliente 04=========================");
                cliente4.mostrarCliente();
                System.out.println("====================Cliente 05=========================");
                cliente5.mostrarCliente();

                System.out.println("=======================================================");
                System.out.println("============REGISTRO PRODUCTOS=========================");
                System.out.println("=======================================================");

                Producto producto1 = new Producto("PR001", "OREO", "COMESTIBLE", 3.50, 1500, 0.25);
                Producto producto2 = new Producto("PR002", "POC KOR", "COMESTIBLE", 4.00, 1000, 0);
                Dulces producto3 = new Dulces("PR003", "CHOCOLATE", "DULCES", 2.50, 1000, 0.15, "Chocolate");
                Bebida producto4 = new Bebida("PR004", "INKA COLA", "BEBIDA", 4.00, 1000, 0.50, 3);

                System.out.println("=================Producto 01===========================");
                producto1.mostrarProducto();
                System.out.println("=================Producto 02===========================");
                producto2.mostrarProducto();
                System.out.println("=================Producto 03===========================");
                producto3.mostrarProducto();
                System.out.println("=================Producto 04===========================");
                producto4.mostrarProducto();

                System.out.println("=======================================================");
                System.out.println("============REGISTRO PELICULAS=========================");
                System.out.println("=======================================================");

                Pelicula pelicula1 = new Pelicula("P001", "Titanic", "Drama", "3hrs", "APT", 15.50);
                Pelicula pelicula2 = new Pelicula("P002", "Avatar", "Ciencia Ficcion", "3hrs 30min", "+13", 20.00);
                PeliculaEstreno pelicula3 = new PeliculaEstreno("P003", "Avengers", "Accion", "2hrs 30min", "+13",
                                22.00, 5.00);
                Pelicula3D pelicula4 = new Pelicula3D("P004", "Spiderman", "Accion", "2hrs 30min", "+13", 22.00, 3.00);

                System.out.println("=================Pelicula 01===========================");
                pelicula1.mostrarPelicula();
                System.out.println("=================Pelicula 02===========================");
                pelicula2.mostrarPelicula();
                System.out.println("=================Pelicula 03===========================");
                pelicula3.mostrarPelicula();
                System.out.println("=================Pelicula 04===========================");
                pelicula4.mostrarPelicula();

                System.out.println("=======================================================");
                System.out.println("============REGISTRO VENTAS ENTRADAS===================");
                System.out.println("=======================================================");

                Entrada entrada1 = new Entrada(cliente1, pelicula1, 3);
                Entrada entrada2 = new Entrada(cliente2, pelicula2, 5);
                EntradaVip entrada3 = new EntradaVip(cliente3, pelicula4, 2, 4);
                EntradaOnline entrada4 = new EntradaOnline(cliente1, pelicula3, 2, 1.50);
                Entrada entrada5 = new Entrada(cliente2, pelicula3, 5);
                Entrada entrada6 = new Entrada(cliente4, pelicula1, 2); // VIP: 30% de descuento
                Entrada entrada7 = new Entrada(cliente5, pelicula3, 2); // Premiun: 30% de descuento

                System.out.println("=================VENTA ENTRADA 01=======================");
                entrada1.mostrarResumenVenta();
                System.out.println("=================VENTA ENTRADA 02=======================");
                entrada2.mostrarResumenVenta();
                System.out.println("=================VENTA ENTRADA 03=======================");
                entrada3.mostrarResumenVenta();
                System.out.println("=================VENTA ENTRADA 04=======================");
                entrada4.mostrarResumenVenta();
                System.out.println("=================VENTA ENTRADA 05=======================");
                entrada5.mostrarResumenVenta();
                System.out.println("=================VENTA ENTRADA 06=======================");
                entrada6.mostrarResumenVenta();
                System.out.println("=================VENTA ENTRADA 07=======================");
                entrada7.mostrarResumenVenta();

                System.out.println("=======================================================");
                System.out.println("============REGISTRO VENTAS CONFITERIA=================");
                System.out.println("=======================================================");

                // Ristro de venta de confiteria
                Confiteria venta1 = new Confiteria("V001", cliente1);
                venta1.agregarProducto(producto1, 2); // venta1.totalItems = 1
                venta1.agregarProducto(producto2, 1); // venta1.totalItems = 2
                venta1.agregarProducto(producto3, 4); // venta1.totalItems = 3
                System.out.println("=======================================================");
                System.out.println("===================VENTA CONFITERIA 01=================");
                venta1.mostrarResumenVenta();

                Confiteria venta2 = new Confiteria("V002", cliente2); // venta2.totalItems = 0
                venta2.agregarProducto(producto2, 3); // venta2.totalItems = 1
                System.out.println("=======================================================");
                System.out.println("===================VENTA CONFITERIA 02=================");
                venta2.mostrarResumenVenta();

                Confiteria venta3 = new Confiteria("V003", cliente3, producto4, 4);
                System.out.println("=======================================================");
                System.out.println("===================VENTA CONFITERIA 03=================");
                venta3.mostrarResumenVenta();

                Confiteria venta4 = new Confiteria("V004", cliente1);
                venta4.agregarProducto(producto1, 5);
                venta4.agregarProducto(producto2, 8);
                venta4.agregarProducto(producto3, 9);
                venta4.agregarProducto(producto4, 6);
                System.out.println("=======================================================");
                System.out.println("===================VENTA CONFITERIA 04=================");
                venta4.mostrarResumenVenta();

                Confiteria venta5 = new Confiteria("V005", cliente2);
                venta5.agregarProducto(producto4, 2);
                venta5.agregarProducto(producto3, 5);
                venta5.agregarProducto(producto1, 7);
                System.out.println("=======================================================");
                System.out.println("===================VENTA CONFITERIA 05=================");
                venta5.mostrarResumenVenta();
        }

}
