package MapeoOR.ClaveCompuesta;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "alumno" )
public class Alumno 
{
	@Column( name = "id" )
	@Id
	private int id ;
	
	@Column( name = "nombre" )
	private String nombre;
	
	@Column( name = "curso" )
	private String curso;
	
	@OneToMany(mappedBy = "alumno")
	private List<Nota> notas;
	
	public Alumno(int id, String nombre, String curso) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
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

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", curso=" + curso + "]";
	}
	
	

	
	

}
