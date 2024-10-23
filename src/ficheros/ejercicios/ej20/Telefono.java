package ficheros.ejercicios.ej20;

import java.io.Serializable;
import java.util.Objects;

public class Telefono implements Serializable {

	String nombre;
	String telefono;
	
	public Telefono()
	{
		
	}
	
	public Telefono(String nombre, String telefono) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Telefono [nombre=" + nombre + ", telefono=" + telefono + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefono other = (Telefono) obj;
		return Objects.equals(nombre, other.nombre) && Objects.equals(telefono, other.telefono);
	}
	
}
