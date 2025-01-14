package MapeoOR.Ejercicio13;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name ="alumno") //Define la clase como una entidad JPA.
@Table(name ="alumno")	//Especifica que la tabla en la base de datos se llama alumno
public class Alumno implements Serializable{
	@Id					//Define el atributo id como clave primaria.
	private int id;
	private String nombre;
	private String curso;
	private int telefono;
	
	
	//mappedBy = "id.alumno" pq en la tabla nota hay una clave compuesta que referencia a alumno
    @OneToMany(mappedBy = "id.alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nota> notas;
   
    

	public Alumno() {
		this.notas= new ArrayList<>();
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	
	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

	public void aniadirNota(Nota nota){
		this.notas.add(nota);
		nota.getId().setAlumno(this);
		
	}
	
	
	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", curso=" + curso + ", telefono=" + telefono + ", notas="
				+ notas + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((notas == null) ? 0 : notas.hashCode());
		result = prime * result + telefono;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (notas == null) {
			if (other.notas != null)
				return false;
		} else if (!notas.equals(other.notas))
			return false;
		if (telefono != other.telefono)
			return false;
		return true;
	}

}