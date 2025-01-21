package MapeoOR.EjercicioPrestamos;

import java.io.Serializable;
<<<<<<< HEAD
import java.sql.Statement;
=======
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
<<<<<<< HEAD
import javax.persistence.JoinColumn;
=======
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro implements Serializable {
<<<<<<< HEAD

=======
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115
	@Id
	private int isbn;
	private int numEjemplar;
	private String titulo;
	private String autor;

<<<<<<< HEAD
	@OneToMany(mappedBy = "libro_prestamo")
	private List<Prestamos> listado_prestamos;
=======
	@OneToMany( mappedBy = "listado_libros" )
	private List<Prestamo> listado_prestamos_libros;
	
	public Libro()
	{
		
	}
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115

	public Libro(int isbn, int numEjemplar, String titulo, String autor) {
		super();
		this.isbn = isbn;
		this.numEjemplar = numEjemplar;
		this.titulo = titulo;
		this.autor = autor;
	}

<<<<<<< HEAD
	public Libro() {

	}

=======
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115
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

<<<<<<< HEAD
	public List<Prestamos> getListado_prestamos() {
		return listado_prestamos;
	}

	public void setListado_prestamos(List<Prestamos> listado_prestamos) {
		this.listado_prestamos = listado_prestamos;
=======
	public List<Prestamo> getListado_prestamos() {
		return listado_prestamos_libros;
	}

	public void setListado_prestamos(List<Prestamo> listado_prestamos) {
		this.listado_prestamos_libros = listado_prestamos;
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115
	}

	@Override
	public String toString() {
<<<<<<< HEAD
		return "Libro [isbn=" + isbn + ", numeroEjemplares=" + numEjemplar + ", titulo=" + titulo + ", autor="
				+ autor + "]";
=======
		return "Libro [isbn=" + isbn + ", numEjemplar=" + numEjemplar + ", titulo=" + titulo + ", autor=" + autor
				+ ", listado_prestamos=" + listado_prestamos_libros + "]";
>>>>>>> f5df2523b21cb9e98f4b69e60557b5f037ab9115
	}

}
