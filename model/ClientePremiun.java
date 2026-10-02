package model;

public class ClientePremiun extends Cliente {
    private String beneficioExclusivo;//"Acceso a preventas de estrenos", "Cola rápida en confitería"

    public ClientePremiun(String codigoCliente, String datosCliente, String direccion, int edad, String telefono,
            String sexo, String nivelMenbresia, String beneficioExclusivo) {
        super(codigoCliente, datosCliente, direccion, edad, telefono, sexo, nivelMenbresia);
        this.beneficioExclusivo = beneficioExclusivo;
    }

    public String getBeneficioExclusivo() {
        return beneficioExclusivo;
    }

    public void setBeneficioExclusivo(String beneficioExclusivo) {
        this.beneficioExclusivo = beneficioExclusivo;
    }

    @Override
    public void mostrarCliente() {
        super.mostrarCliente();
        System.out.println("Beneficio Exclusivo \t:" + beneficioExclusivo);
    }   


}
