package base_de_datos.Ejercicio2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Alumno {
	
	private int id;
	private String nombre;
	private String curso;
	HashMap<String, List<Integer>> modulos_notas = new HashMap<String, List<Integer>>();
	
	public Alumno(int id, String nombre, String curso, HashMap<String, List<Integer>> modulos_notas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.curso = curso;
		this.modulos_notas = modulos_notas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public HashMap<String, List<Integer>> getModulos_notas() {
		return modulos_notas;
	}

	public void setModulos_notas(HashMap<String, List<Integer>> modulos_notas) {
		this.modulos_notas = modulos_notas;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", curso=" + curso + ", modulos_notas=" + modulos_notas
				+ "]";
	}
}
