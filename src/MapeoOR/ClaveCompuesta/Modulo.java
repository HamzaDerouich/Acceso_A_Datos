package MapeoOR.ClaveCompuesta;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "modulo")
public class Modulo {
	@Id
	@Column(name = "codigo")
	private String codigo;

	@Column(name = "nombre")
	private String nombre;

	public Modulo(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Modulo() {

	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Modulo [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
