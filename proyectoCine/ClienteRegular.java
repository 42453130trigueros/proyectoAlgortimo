public class ClienteRegular extends Cliente {
    private double descuento;

    public ClienteRegular(String codigoCliente, String datosCliente, String direccion, int edad, String telefono,
            String sexo, String nivelMenbresia, double descuento) {
        super(codigoCliente, datosCliente, direccion, edad, telefono, sexo, nivelMenbresia);
        this.descuento = descuento;
    }

    @Override
    public void mostrarCliente() {
        super.mostrarCliente();
        System.out.println("Descuento \t\t:" + descuento);
    }

}
