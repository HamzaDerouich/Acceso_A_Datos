package base_de_datos.Ejercicios_2_3_4;

public class Tabla 
{
	private String nombre;

	public Tabla(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Tabla [nombre=" + nombre + "]";
	}
	
}
