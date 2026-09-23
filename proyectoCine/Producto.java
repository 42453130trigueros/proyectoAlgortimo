public class Producto {
    private String nombreProducto;
    private String categoria;
    private double precioProducto;
    private int stock;
    private double promocion;

    // constructor
    public Producto(String nombreProducto, String categoria, double precioProducto, int stock, double promocion) {
        this.nombreProducto = nombreProducto;
        this.categoria = categoria;

        if (precioProducto > 0) {
            this.precioProducto = precioProducto;
        }

        if (stock > 0) {
            this.stock = stock;
        }

        if (promocion > 0) {
            this.promocion = promocion;
        }

    }

    // getters
    public String getNombreProducto() {
        return nombreProducto;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecioProducto() {
        return precioProducto;
    }

    public int getStock() {
        return stock;
    }

    public double getPromocion() {
        return promocion;
    }

    // setters
    public void setPrecioProducto(double precioProducto) {
        if (precioProducto > 0) {
            this.precioProducto = precioProducto;
        }
    }

    public void setStock(int stock) {
        if (stock > 0) {
            this.stock = stock;
        }
    }

    public void setPromocion(double promocion) {
        if (promocion > 0) {
            this.promocion = promocion;
        }
    }

    //metodo sin parametros
        void mostrarProducto() {
        System.out.println("==========================================");
        System.out.println("Nombre del Producto \t:" + nombreProducto);
        System.out.println("Categoria del Producto \t:" + categoria);
        System.out.println("Precio  \t\t:" + precioProducto);
        System.out.println("Stock  \t\t\t:" +stock);
        System.out.println("% Promocion \t\t:" + (promocion*100)+"%");
        
    }


}
