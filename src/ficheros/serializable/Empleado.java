package ficheros.serializable;

import java.io.Serializable;
import java.util.Objects;

public class Empleado implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String dni;
	private String nombre;
	private double sueldo;
	
	public Empleado()
	{
		
	}
	
	public Empleado(String dni, String nombre, double sueldo) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.sueldo = sueldo;
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

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dni, nombre, sueldo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(dni, other.dni) && Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(sueldo) == Double.doubleToLongBits(other.sueldo);
	}
	
	@Override
	public String toString() {
		return "Empleado [dni=" + dni + ", nombre=" + nombre + ", sueldo=" + sueldo + "]";
	}
	
}
