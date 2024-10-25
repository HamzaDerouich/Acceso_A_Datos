package ficherosJson;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class ListadoAlumnos {

	public static List<Alumno> alumnos;

	public List<Alumno> getAlumnos()
	{
		return alumnos;
	}

	public void setAlumnos(List<Alumno> alumnos)
	{
		this.alumnos = alumnos;
	}

	public static void MostrarAlumnos() {
		for (Alumno alumno : alumnos) {
			System.out.println("Alumno: " + alumno);
		}
	}

}
