package Ejercicio_Final;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "libro")
public class Libro implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int isbn;

	private int numero_ejemplares;

	private String titulo;

	private String autor;

	@OneToMany(mappedBy = "libro", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Prestamo> listado_prestamos;

	public Libro(int isbn, int numeros_ejemplares, String titulo, String autor) {
		
		this.isbn = isbn;
		this.numero_ejemplares = numeros_ejemplares;
		this.titulo = titulo;
		this.autor = autor;
	}

	public Libro() {
		super();
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
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

	public List<Prestamo> getListado_prestamos() {
		return listado_prestamos;
	}

	public void setListado_prestamos(List<Prestamo> listado_prestamos) {
		this.listado_prestamos = listado_prestamos;
	}

	
	public int getNumero_ejemplares() {
		return numero_ejemplares;
	}

	public void setNumero_ejemplares(int numero_ejemplares) {
		this.numero_ejemplares = numero_ejemplares;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", listado_prestamos="
				+ listado_prestamos + "]";
	}

}
