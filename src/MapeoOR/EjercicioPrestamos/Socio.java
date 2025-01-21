package MapeoOR.EjercicioPrestamos;

import java.io.Serializable;
import java.util.List;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table( name = "socio" )
public class Socio implements Serializable {

	@Id
	private int dni;
	private String nombre;
	private String numTelefono;

	@OneToMany(mappedBy = "socio_prestamo")
	private List<Prestamos> listado_prestamos;

	public Socio(int dni, String nombre, String numTelefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.numTelefono = numTelefono;
	}

	public Socio() {

	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public List<Prestamos> getListado_prestamos() {
		return listado_prestamos;
	}

	public void setListado_prestamos(List<Prestamos> listado_prestamos) {
		this.listado_prestamos = listado_prestamos;
	}

	@Override
	public String toString() {
		return "Socio [dni=" + dni + ", nombre=" + nombre + ", numTelefono=" + numTelefono + "]";
	}

}
