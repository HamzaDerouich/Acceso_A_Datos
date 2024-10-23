package ficheros.ejercicios.ej23;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AgregarAlumnos 
{
	
	public static void Agregar_Alumnos_Fichero()
	{
		Alumno alumno_uno = new Alumno(123, "Ramon Monago", 5.0f); 
		Alumno alumno_dos = new Alumno(333, "Paco Leon", 9.0f); 

		
		File fichero_alumnos = new File("ficheros/alumnos.bin");
		try 
		{
			DataOutputStream escritor = new DataOutputStream(new FileOutputStream(fichero_alumnos,true));
			
			// Datos alumno uno 
			escritor.writeInt(alumno_uno.getExpediente());
			escritor.writeUTF(alumno_uno.getNombre());
			escritor.writeFloat(alumno_uno.getNota());
			
			
			// Datos alumno dos
			escritor.writeInt(alumno_dos.getExpediente());
			escritor.writeUTF(alumno_dos.getNombre());
			escritor.writeFloat(alumno_dos.getNota());
		
			escritor.close();
			
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}

	public static void main(String [] args)
	{
		Agregar_Alumnos_Fichero();
	}
}
