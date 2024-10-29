package ficherosJson;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class EscribirFicheroJson
{
	public static void Escribir()
	{
		Alumno alumno = new Alumno("Hamza", 21, "12345678");
		File fichero = new File( "FicherosJSON/Alumno.json");
		ObjectMapper escritor = new ObjectMapper();
		escritor.enable(SerializationFeature.INDENT_OUTPUT);
		try
		{
			escritor.writeValue(fichero,alumno);
			System.out.println("Alumno registrado!");
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args)
	{
		Escribir();	
	}
}
