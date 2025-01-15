package MapeoOR.Ejercicios.Ejercicio25;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class Alumno 
{
	@Id
	private int id;
	private String nombre;
	private String curso;
	private String telefono;
	
	public Alumno() {
	}
	
	public Alumno(String nombre, String curso, String telefono) {
		this.nombre = nombre;
		this.curso = curso;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", curso=" + curso + ", telefono=" + telefono + "]";
	}

}
