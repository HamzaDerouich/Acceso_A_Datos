package MapeoOR.ClaveCompuesta;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class NotaId implements Serializable {
	

	private int alumno;
	private String modulo;
	
	public NotaId(int alumno, String modulo) {
		super();
		this.alumno = alumno;
		this.modulo = modulo;
	}

	public int getAlumno() {
		return alumno;
	}

	public void setAlumno(int alumno) {
		this.alumno = alumno;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	@Override
	public String toString() {
		return "NotaId [alumno=" + alumno + ", modulo=" + modulo + "]";
	}
	
	
	

}
