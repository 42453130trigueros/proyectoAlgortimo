package model;

public class ClienteVip extends Cliente {
    private String servicioExclusivo;// "Sala VIP con asientos reclinables", "Atención personalizada"

    public ClienteVip(String codigoCliente, String datosCliente, String direccion, int edad, String telefono,
            String sexo, String servicioExclusivo) {
        super(codigoCliente, datosCliente, direccion, edad, telefono, sexo, "VIP");
        this.servicioExclusivo = servicioExclusivo;
    }

    public String getServicioExclusivo() {
        return servicioExclusivo;
    }

    public void setServicioExclusivo(String servicioExclusivo) {
        this.servicioExclusivo = servicioExclusivo;
    }

    @Override
    public void mostrarCliente() {
        super.mostrarCliente();
        System.out.println("Servicio Exclusivo \t:" + servicioExclusivo);
    }

}
