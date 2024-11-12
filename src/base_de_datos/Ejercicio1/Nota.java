package base_de_datos.Ejercicio1;

public class Nota {

	private int alumno;
	private String modulo;
	private int nota;

	public Nota(int alumno, String modulo, int nota) {
		super();
		this.alumno = alumno;
		this.modulo = modulo;
		this.nota = nota;
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

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Nota [alumno=" + alumno + ", modulo=" + modulo + ", nota=" + nota + "]";
	}

}
