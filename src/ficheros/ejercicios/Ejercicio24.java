package ficheros.ejercicios;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ejercicio24 {

	public static void LeerFicherosAlumnos()
	{
		int expediente;
		String nombre;
		float nota;
		File fichero = new File("ficheros/alumnos.bin");
		try ( DataInputStream lector = new DataInputStream(new FileInputStream(fichero))  )
		{
			while(true)
			{
				try {
					
					expediente = lector.readInt();
					nombre = lector.readUTF();
					nota = lector.readFloat();
					
					System.out.println("Expediente: " + expediente);
					System.out.println("Nombre: " + nombre);
					System.out.println("Nota: " + nota);
					System.out.println("------------------------------");
					
					
				}catch (EOFException e) 
				{
					System.out.println("Fin del archivo");
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)
	{
		LeerFicherosAlumnos();
	}

}
