package EjercicioFinal.Ejercicio2;

import java.io.Serializable;

public class Apetito  implements Serializable
{
	private String nombre;
	private int edad;
	private double peso;
	
	public Apetito()
	{
		
	}

	public Apetito(String nombre, int edad, double peso) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
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

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Apetito [nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + "]";
	}
	
}
