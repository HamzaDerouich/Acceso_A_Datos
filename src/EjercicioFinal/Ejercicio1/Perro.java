package EjercicioFinal.Ejercicio1;

import java.io.Serializable;

public class Perro implements Serializable {
	private String Nombre;
	private String Raza;
	private int Edad;
	private double Peso;
	private boolean Estado_Salud;
	private String Descripcion;
	
	
	public Perro()
	{
		
	}
	
	public Perro(String nombre, String raza, int edad, double peso, boolean estado_Salud, String descripcion) {
		super();
		Nombre = nombre;
		Raza = raza;
		Edad = edad;
		Peso = peso;
		Estado_Salud = estado_Salud;
		Descripcion = descripcion;
	}
	
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getRaza() {
		return Raza;
	}
	public void setRaza(String raza) {
		Raza = raza;
	}
	public int getEdad() {
		return Edad;
	}
	public void setEdad(int edad) {
		Edad = edad;
	}
	public double getPeso() {
		return Peso;
	}
	public void setPeso(double peso) {
		Peso = peso;
	}
	public boolean isEstado_Salud() {
		return Estado_Salud;
	}
	public void setEstado_Salud(boolean estado_Salud) {
		Estado_Salud = estado_Salud;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Perro [Nombre=" + Nombre + ", Raza=" + Raza + ", Edad=" + Edad + ", Peso=" + Peso + ", Estado_Salud="
				+ Estado_Salud + ", Descripcion=" + Descripcion + "]";
	}
	
}
