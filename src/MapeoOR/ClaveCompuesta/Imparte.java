package MapeoOR.ClaveCompuesta;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "imparte")
public class Imparte 
{
	private int profesor;
	private String modulo;
	
	public Imparte(int profesor, String modulo) {
		super();
		this.profesor = profesor;
		this.modulo = modulo;
	}

	public int getProfesor() {
		return profesor;
	}

	public void setProfesor(int profesor) {
		this.profesor = profesor;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	@Override
	public String toString() {
		return "Imparte [profesor=" + profesor + ", modulo=" + modulo + "]";
	}
	
	
}
