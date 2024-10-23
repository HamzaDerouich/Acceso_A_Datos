package ficheros.ejercicios.Ej29;

import java.io.Serializable;

public class Alumno implements Serializable {
	
	private int expediente;
	private String nombre;
	private int nota;
	
	public Alumno()
	{
		
	}


	public Alumno(int expediente, String nombre, int nota) {
		super();
		this.expediente = expediente;
		this.nombre = nombre;
		this.nota = nota;
	}
	
	public int getExpediente() {
		return expediente;
	}


	public void setExpediente(int expediente) {
		this.expediente = expediente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getNota() {
		return nota;
	}


	public void setNota(int nota) {
		this.nota = nota;
	}


	
	@Override
	public String toString() {
		return "Alumno [expediente=" + expediente + ", nombre=" + nombre + ", nota=" + nota + "]";
	}

	
	

}
