package MapeoOR.EjercicioPrestamos;

import java.io.Serializable;
import java.util.List;

<<<<<<< HEAD
import javax.annotation.processing.Generated;
=======
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
<<<<<<< HEAD
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
=======

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
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.numTelefono = numTelefono;
	}

<<<<<<< HEAD
	public Socio() {

	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
=======
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115
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

<<<<<<< HEAD
	public List<Prestamos> getListado_prestamos() {
		return listado_prestamos;
	}

	public void setListado_prestamos(List<Prestamos> listado_prestamos) {
		this.listado_prestamos = listado_prestamos;
=======
	public List<Prestamo> getListado_prestamos_socios() {
		return listado_prestamos_socios;
	}

	public void setListado_prestamos_socios(List<Prestamo> listado_prestamos_socios) {
		this.listado_prestamos_socios = listado_prestamos_socios;
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Socio [dni=" + dni + ", nombre=" + nombre + ", numTelefono=" + numTelefono + "]";
=======
		return "Socio [dni=" + dni + ", nombre=" + nombre + ", numTelefono=" + numTelefono
				+ ", listado_prestamos_socios=" + listado_prestamos_socios + "]";
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115
	}

}
