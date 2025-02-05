/*
package MapeoOR.EjercicioPrestamos;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrestamo;
	
	private boolean prestado;

	@ManyToOne
	@JoinColumn(name = "socioDni", referencedColumnName = "dni")
	private Socio listado_socios;

	
	@ManyToOne
	@JoinColumn(name = "libroIsbn", referencedColumnName = "isbn")
	private Libro listado_libros;

	public Prestamo() {

	}

	public Prestamo(boolean prestado, Libro libro , Socio socio) {
		this.prestado = prestado;
		this.listado_libros = libro;
		this.listado_socios = socio;
	}
	
	public Prestamo(int idPrestamo, boolean prestado, Libro libro , Socio socio) {
		this.idPrestamo = idPrestamo;
		this.prestado = prestado;
		this.listado_libros = libro;
		this.listado_socios = socio;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}

	public void setIdPrestamo(int idPrestamo) {
		this.idPrestamo = idPrestamo;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public Socio getListado_socios() {
		return listado_socios;
	}

	public void setListado_socios(Socio listado_socios) {
		this.listado_socios = listado_socios;
	}

	public Libro getListado_libros() {
		return listado_libros;
	}

	public void setListado_libros(Libro listado_libros) {
		this.listado_libros = listado_libros;
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", prestado=" + prestado + ", listado_socios=" + listado_socios
				+ ", listado_libros=" + listado_libros + "]";
	}

}
*/
