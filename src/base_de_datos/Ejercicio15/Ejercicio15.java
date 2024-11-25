package base_de_datos.Ejercicio15;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Ejercicio15 
{
	static Scanner sc = new Scanner(System.in);
	
	public static Path PedirRutaFichero()
	{
		String ruta = "" ;
		
		System.out.println("Introduce la ruta del fichero..");
		ruta = sc.nextLine();
		
		File file = new File(ruta);
		
		if ( file.exists() )
		{
			return file.toPath();
		}
		else 
		{
			System.out.println("El fichero no existe!!");
		}
		
		return null;
		
		
	}
	
	public static void EjecutarScript(Path ruta_fichero)
	{
		Conexion conexion = new Conexion();
		try {
			String script = new String(Files.readAllBytes(ruta_fichero));
			conexion.EjecutarScript(script);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main( String [] args)
	{
		Path ruta = PedirRutaFichero();
		EjecutarScript(ruta);
		
	}
}
