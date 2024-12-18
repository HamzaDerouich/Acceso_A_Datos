package MapeoOR.ClaveCompuesta;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nota")
public class Nota {
	
	@EmbeddedId
	
	private NotaId id;

	private double nota;

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
	public String toString() {
		return "Nota [id=" + id + ", nota=" + nota + "]";
	}

}
