package PostGresSql.Ejercicio9;

public class Propietario {

	private String dni;
	private String nombre;
	private Direccion direccion;

	public Propietario(String dni, String nombre, Direccion direccion) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Veterinario [dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}

}
