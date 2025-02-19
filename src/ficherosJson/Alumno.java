package ficherosJson;

import java.io.Serializable;

public class Alumno implements Serializable {
	
	private String nombre;
	private int edad;
	private String dni;
	
	public Alumno()
	{
		
	}
	
	public Alumno(String nombre, int edad, String dni) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", edad=" + edad + ", dni=" + dni + "]";
	}
	
}
