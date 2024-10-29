package ficherosJson.ejercicios.Ej45;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import ficherosJson.Alumno;

public class Ejercicio45 {
	
	public static void EscribirAlumnos()
	{
		Alumno alumno1 = new Alumno("Pedro", 23, "21315321");
		Alumno alumno2 = new Alumno("Fernando", 45, "123174");
		Alumno alumno3 = new Alumno("Juan", 65, "454546563");
		
		Alumno[] alumnos = {alumno1,alumno2,alumno3};
		
		try
		{
			ObjectMapper escritor = new ObjectMapper();
			escritor.enable(SerializationFeature.INDENT_OUTPUT);
			
			for (Alumno alumno : alumnos) 
			{
				escritor.writeValue(new File("FicherosJSON/listadoAlumnos.json"), alumnos);
				System.out.println("Alumno con nombre :"+ alumno.getDni()  +" registrado!!");
				System.out.println("_____________________________________");
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args)
	{
		EscribirAlumnos();
	}

}
