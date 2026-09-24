public class Cliente {
    private String codigoCliente;
    private String datosCliente;
    private String direccion;
    private int edad;
    private String telefono;
    private String sexo;
    private String nivelMenbresia;

    // construtor
    public Cliente(String codigoCliente, String datosCliente, String direccion, int edad, String telefono, String sexo,
            String nivelMenbresia) {

        this.codigoCliente = codigoCliente;
        this.datosCliente = datosCliente;
        this.direccion = direccion;

        if (edad > 0) {
            this.edad = edad;
        }

        this.telefono = telefono;

        if (sexo.equals("M") || sexo.equals("F")) {
            this.sexo = sexo;
        }

        if (nivelMenbresia.equals("Regular") || nivelMenbresia.equals("Premiun")) {
            this.nivelMenbresia = nivelMenbresia;
        }

    }

    // getters
    public String getCodigoCliente() {
        return codigoCliente;
    }

    public String getDatosCliente() {
        return datosCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public String getNivelMenbresia() {
        return nivelMenbresia;
    }

    // setters
    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public void setDatosCliente(String datosCliente) {
        this.datosCliente = datosCliente;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setNivelMenbresia(String nivelMenbresia) {
        this.nivelMenbresia = nivelMenbresia;
    }

    // metodo sin parametros
    void mostrarCliente() {
        System.out.println("==========================================");
        System.out.println("Codigo del Cliente \t:" + codigoCliente);
        System.out.println("Datos del Cliente \t:" + datosCliente);
        System.out.println("Direccion \t\t:" + direccion);
        System.out.println("Edad  \t\t\t:" + edad);
        System.out.println("Telefono  \t\t:" + telefono);
        System.out.println("Sexo \t\t\t:" + sexo);
        System.out.println("Nivel Menbresia \t:" + nivelMenbresia);

    }

    // metodo con parametros
    public double calcularDescuentoCliente(double precioEntrada) {
        double descuento = 0;

        if (nivelMenbresia.equals("Regular")) {
            descuento = precioEntrada * 0.20;
        } else if (nivelMenbresia.equals("Premiun")) {
            descuento = precioEntrada * 0.10;
        }

        return descuento;
    }

}
