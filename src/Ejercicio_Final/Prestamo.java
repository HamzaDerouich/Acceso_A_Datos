package Ejercicio_Final;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private int id_prestamo;

	private boolean prestado;


	@ManyToOne 
	@JoinColumn(name = "socio", referencedColumnName = "dni")
	private Socio socio;

	@ManyToOne
	@JoinColumn(name = "libro", referencedColumnName = "isbn")
	private Libro libro;

	public Prestamo( boolean prestado, Socio socio, Libro libro) {
		super();
		this.prestado = prestado;
		this.socio = socio;
		this.libro = libro;
	}

	public Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_prestamo() {
		return id_prestamo;
	}

	public void setId_prestamo(int id_prestamo) {
		this.id_prestamo = id_prestamo;
	}

	public boolean isPrestado() {
		return prestado;
	}

	public void setPrestado(boolean prestado) {
		this.prestado = prestado;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "Prestamo [id_prestamo=" + id_prestamo + ", prestado=" + prestado + ", socio=" + socio + ", libro="
				+ libro + "]";
	}

}
