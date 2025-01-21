package Ejercicio_Final;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "socio")
public class Socio implements Serializable {

	@Id
	private String dni;

	private String nombre;

	private String num_telefono;

	@OneToMany(mappedBy = "socio", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Prestamo> listado_prestamos;

	public Socio() {
		super();
	}

	public Socio(String dni, String nombre, String numTelefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.num_telefono = numTelefono;
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

	public String getNumTelefono() {
		return num_telefono;
	}

	public List<Prestamo> getListado_prestamos() {
		return listado_prestamos;
	}

	public void setListado_prestamos(List<Prestamo> listado_prestamos) {
		this.listado_prestamos = listado_prestamos;
	}

	public void setNumTelefono(String numTelefono) {
		this.num_telefono = numTelefono;
	}

	@Override
	public String toString() {
		return "Socio [dni=" + dni + ", nombre=" + nombre + ", numTelefono=" + num_telefono + ", listado_prestamos="
				+ listado_prestamos + "]";
	}

}
