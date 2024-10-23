package ficheros;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirFicherosBinarios 
{
	
	public static void EscribirFichero()
	{
		String archivo = "ficheros/datos.bin"; // Archivo donde guardaremos los datos
		
		// Escribir datos en el archivo binario usando DataOutputStream
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(archivo)))
		{
		dos.writeInt(42); // Escribimos un entero
		dos.writeDouble(3.1416); // Escribimos un doble
		dos.writeUTF("Hola"); // Escribimos una cadena en formato UTF
		System.out.println("Datos escritos en el archivo binario.");
		} catch (IOException e) {
		e.printStackTrace();
		}

	}
	
	public static void main( String [] args )
	{
		EscribirFichero();
	}

}
