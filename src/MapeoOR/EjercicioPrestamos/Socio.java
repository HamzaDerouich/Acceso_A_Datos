package MapeoOR.EjercicioPrestamos;

import java.io.Serializable;
import java.util.List;

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
	private String numTelefono;

	@OneToMany(mappedBy = "listado_socios")
	private List<Prestamo> listado_prestamos_socios;

	public Socio() {

	}

	public Socio(String dni, String nombre, String numTelefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.numTelefono = numTelefono;
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
		return numTelefono;
	}

	public void setNumTelefono(String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public List<Prestamo> getListado_prestamos_socios() {
		return listado_prestamos_socios;
	}

	public void setListado_prestamos_socios(List<Prestamo> listado_prestamos_socios) {
		this.listado_prestamos_socios = listado_prestamos_socios;
	}

	@Override
	public String toString() {
		return "Socio [dni=" + dni + ", nombre=" + nombre + ", numTelefono=" + numTelefono
				+ ", listado_prestamos_socios=" + listado_prestamos_socios + "]";
	}

}
