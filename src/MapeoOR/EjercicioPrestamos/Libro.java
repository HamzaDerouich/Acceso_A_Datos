package MapeoOR.EjercicioPrestamos;

import java.io.Serializable;
import java.sql.Statement;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro implements Serializable {

	@Id
	private int isbn;
	private int numEjemplar;
	private String titulo;
	private String autor;

	@OneToMany(mappedBy = "libro_prestamo")
	private List<Prestamos> listado_prestamos;

	public Libro(int isbn, int numEjemplar, String titulo, String autor) {
		super();
		this.isbn = isbn;
		this.numEjemplar = numEjemplar;
		this.titulo = titulo;
		this.autor = autor;
	}

	public Libro() {

	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public int getNumEjemplar() {
		return numEjemplar;
	}

	public void setNumEjemplar(int numEjemplar) {
		this.numEjemplar = numEjemplar;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<Prestamos> getListado_prestamos() {
		return listado_prestamos;
	}

	public void setListado_prestamos(List<Prestamos> listado_prestamos) {
		this.listado_prestamos = listado_prestamos;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", numeroEjemplares=" + numEjemplar + ", titulo=" + titulo + ", autor="
				+ autor + "]";
	}

}
