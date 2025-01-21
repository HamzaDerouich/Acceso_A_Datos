package MapeoOR.EjercicioPrestamos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@NamedNativeQuery(
	    name = "Prestamos.TotalPrestamos",
	    query = "SELECT COUNT(*) FROM prestamo WHERE prestamo.prestado = true"
	)
@Table(name = "prestamo")
public class Prestamos implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrestamo;
	
	@Column( name = "prestado" )
	private boolean prestado;

	@ManyToOne
	@JoinColumn(name = "libro", referencedColumnName = "isbn")
	private Libro libro_prestamo;


	@ManyToOne
	@JoinColumn(name = "socioDni", referencedColumnName = "dni")
	private Socio socio_prestamo;

	public Prestamos() {

	}

	
	
	public Prestamos(int idPrestamo, boolean prestado, Libro libro_prestamo, Socio socio_prestamo) {
		super();
		this.idPrestamo = idPrestamo;
		this.prestado = prestado;
		this.libro_prestamo = libro_prestamo;
		this.socio_prestamo = socio_prestamo;
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

	public Libro getLibro_prestamo() {
		return libro_prestamo;
	}

	public void setLibro_prestamo(Libro libro_prestamo) {
		this.libro_prestamo = libro_prestamo;
	}

	public Socio getSocio_prestamo() {
		return socio_prestamo;
	}

	public void setSocio_prestamo(Socio socio_prestamo) {
		this.socio_prestamo = socio_prestamo;
	}

	@Override
	public String toString() {
		return "Prestamos [idPrestamo=" + idPrestamo + ", prestado=" + prestado + ", libro_prestamo=" + libro_prestamo
				+ ", socio_prestamo=" + socio_prestamo + "]";
	}
	
	

}
