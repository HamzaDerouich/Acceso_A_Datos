package ficheros.ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String ruta ;
		System.out.println("Ingrese la ruta del fichero o directorio");
		ruta = scanner.nextLine();
		File fichero = new File(ruta);
		
		if( fichero.exists() )
		{
			if(fichero.isFile())
			{
				System.out.println("Es un fichero");
				System.out.println("El tamaño del fichero es: " +  fichero.length());
			}
			else
			{
				System.out.println("Es un directorio");
				System.out.println("El tamaño del directorio es: " +  fichero.length());
			}
		}
		else
		{
			System.out.println("El fichero no existe!!");
		}
		
	}

}
