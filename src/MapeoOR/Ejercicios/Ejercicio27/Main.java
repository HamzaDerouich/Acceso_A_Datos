package MapeoOR.Ejercicios.Ejercicio27;

import java.util.Scanner;

public class Main {
	
	public static void main( String [] args )
	{
		GestionALumnos();
	}

	private static void GestionALumnos() 
	{
		try
		{
			String curso = "";
			Scanner sc = new Scanner(System.in);
			while (!curso.isEmpty() == false) {
				System.out.println("El curso no puede estar vacio");
				System.out.println("Ingrese el curso del alumno: ");
				curso = sc.nextLine();
			}
			
			Crud crud = new Crud();
			
			for (Alumno alumno : crud.obtenerAlumnos(curso)) {
				System.out.println("Datos del alumno: ");
				System.out.println("Nombre: " + alumno.getNombre());
				System.out.println("Curso: " + alumno.getCurso());
				System.out.println("Telefono: " + alumno.getTelefono());
			}
			
		
		} catch (Exception e) 
		{
			System.out.println("Datos no validos");
			e.printStackTrace();
		}
		

	}

}
