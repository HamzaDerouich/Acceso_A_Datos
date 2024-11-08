package ExamenHamzaDerouich.prueba4;

public class RopaXml 
{
	private String nombre;
	private String talla;
	private String color;
	private String estado;
	
	
	public RopaXml(String nombre, String talla, String color, String estado) {
		this.nombre = nombre;
		this.talla = talla;
		this.color = color;
		this.estado = estado;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getTalla() {
		return talla;
	}


	public void setTalla(String talla) {
		this.talla = talla;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	@Override
	public String toString() {
		return "RopaXml [nombre=" + nombre + ", talla=" + talla + ", color=" + color + ", estado=" + estado + "]";
	}
	
	
	
	
}
