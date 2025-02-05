package PostGresSql.Ejercicio8;

public class Veterinario {

	private String dni;
	private String nombre;
	private Direccion direccion;
	private long numeroColegiado;

	public Veterinario(String dni, String nombre, Direccion direccion, long numeroColegiado) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroColegiado = numeroColegiado;
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

	public long getNumeroColegiado() {
		return numeroColegiado;
	}

	public void setNumeroColegiado(long numeroColegiado) {
		this.numeroColegiado = numeroColegiado;
	}

	@Override
	public String toString() {
		return "Veterinario [dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", numeroColegiado="
				+ numeroColegiado + "]";
	}

}
