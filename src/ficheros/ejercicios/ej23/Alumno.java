package ficheros.ejercicios.ej23;

import java.io.Serializable;

public class Alumno implements Serializable 
{
	private int expediente ;
	private String nombre;
	private float nota;
	
	public Alumno(int expediente, String nombre, float nota) {
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
	public float getNota() {
		return nota;
	}
	public void setNota(float nota) {
		this.nota = nota;
	}
	
	@Override
	public String toString() {
		return "Alumno [Expediente:  " + expediente + " nombre:  " + nombre + " nota:  " + nota + "]";
	}
	
	
}
