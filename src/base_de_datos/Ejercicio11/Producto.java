package base_de_datos.Ejercicio11;

public class Producto {
    
    private int idProducto;
    private String nombreProducto;
    private int idCategoria;
    private int idTalla;
    private int idColor;
    private int idMaterial;
    private int stock;
    private double precio;
    private double costo;
    private String estado;
    private double descuento;

        public Producto(int idProducto, String nombreProducto, int idCategoria, int idTalla, int idColor, int idMaterial, 
                    int stock, double precio, double costo, String estado, double descuento) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.idCategoria = idCategoria;
        this.idTalla = idTalla;
        this.idColor = idColor;
        this.idMaterial = idMaterial;
        this.stock = stock;
        this.precio = precio;
        this.costo = costo;
        this.estado = estado;
        this.descuento = descuento;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(int idTalla) {
        this.idTalla = idTalla;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", idCategoria=" + idCategoria +
                ", idTalla=" + idTalla +
                ", idColor=" + idColor +
                ", idMaterial=" + idMaterial +
                ", stock=" + stock +
                ", precio=" + precio +
                ", costo=" + costo +
                ", estado='" + estado + '\'' +
                ", descuento=" + descuento +
                '}';
    }
}
