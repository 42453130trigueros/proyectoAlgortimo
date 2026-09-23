public class main {
    public static void main(String[] args) {
        System.out.println("==========================================");
        Cliente cliente1=new Cliente("Jose Marin", "av jose galvez 668", 30, "00958550", "M","Premiun");
        System.out.println("==============Cliente 01==================");
        cliente1.mostrarCliente();
        
        System.out.println("==========================================");
        Producto producto1=new Producto("SUBLIME", "CHOCOLATE", 3.50, 1500, 0.25);
        System.out.println("==============Producto 01=================");
        producto1.mostrarProducto();


        System.out.println("==========================================");
        Pelicula pelicula1=new Pelicula("Titanic","Drama","3hrs","APT",15.50);
        System.out.println("==============Pelicula 01=================");
        pelicula1.mostrarPelicula();



    }
}
