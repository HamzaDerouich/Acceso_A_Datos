package MapeoOR.ClaveCompuesta;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nota")
public class Nota {
	
	@EmbeddedId
	private NotaId id;

	private double nota;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Alumno alumno;

	public Nota(NotaId id, double nota) {
		super();
		this.id = id;
		this.nota = nota;
	}

	public NotaId getId() {
		return id;
	}

	public void setId(NotaId id) {
		this.id = id;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(id, other.id) && Double.doubleToLongBits(nota) == Double.doubleToLongBits(other.nota);
	}

	@Override
	public String toString() {
		return "Nota [id=" + id + ", nota=" + nota + "]";
	}

	
	
}
