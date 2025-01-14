package MapeoOR.Ejercicio13;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable // Indica que esta clase se usará como clave compuesta.
public class NotaId implements Serializable 
{
	
	@ManyToOne // con la tabla/entidad alumno
	@JoinColumn(name = "alumno", referencedColumnName = "id")
	private Alumno alumno;

	// @JoinColumn
	// name es el nombre de la columna en la tabla de la bd
	// referencedColumnName el campo que es clave en la otra tabla.

	@ManyToOne // con la tabla/entidad modulo
	@JoinColumn(name = "modulo", referencedColumnName = "codigo")
	private Modulo modulo;

	// @JoinColumn
	// name es el nombre de la columna en la tabla de la bd
	// referencedColumnName el campo que es clave en la otra tabla.

	// Constructores, getters, setters, equals y hashCode
	public NotaId() {
	}

	public NotaId(Alumno alumno, Modulo modulo) {
		this.alumno = alumno;
		this.modulo = modulo;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	@Override
	public String toString() {
		return "NotaId [alumno=" + alumno + ", modulo=" + modulo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((modulo == null) ? 0 : modulo.hashCode());
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
		NotaId other = (NotaId) obj;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (modulo == null) {
			if (other.modulo != null)
				return false;
		} else if (!modulo.equals(other.modulo))
			return false;
		return true;
	}

}