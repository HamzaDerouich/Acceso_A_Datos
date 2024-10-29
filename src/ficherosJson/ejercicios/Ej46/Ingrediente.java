package ficherosJson.ejercicios.Ej46;

class Ingrediente {
	
	private String nombre;
    private String cantidad;

    public Ingrediente() {}

    public Ingrediente(String nombre, String cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
   	public String toString() {
   		return "Ingrediente [nombre=" + nombre + ", cantidad=" + cantidad + "]";
   	}

}
