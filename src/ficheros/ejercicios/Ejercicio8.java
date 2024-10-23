package ficheros.ejercicios;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class Ejercicio8 {
	

	/*
	 * Realiza un programa que pida por teclado una ruta de carpeta y si existe
	 * muestre su contenido y el contenido de todos sus hijos tantos directos como
	 * indirectos. Tal y como muestra la imagen.
	 */

	public static void Ejercicio8() {

		Scanner sc = new Scanner(System.in);
		String rutaCarpeta = "";
		System.out.println("Introduce la ruta de la carpeta: ");
		rutaCarpeta = sc.nextLine();
		
		File directorio = new File(rutaCarpeta);
		
		if( directorio.exists() )
		{
			File[] file = directorio.listFiles();
			
			for( File i : file )
			{
				if( i.isDirectory() )
				{
					System.out.println("[D] " + i.getName());
					MostrarInformacion(i,0);
				}
			}
		}
		else
		{
			System.out.println("El directorio no existe!!");
		}
		
		
	}
	
	private static void MostrarInformacion(File directorio, int nivel)
	{
		String indentacion = "\t".repeat(nivel);
		File[] file = directorio.listFiles(); 
		for (File i : file) {
			if (i.isDirectory()) {
				System.out.println("[D] " + i.getName());
				MostrarInformacion(i, nivel + 1);
			} else {
                System.out.println(indentacion + "\t[F] " + i.getName());

			}
		}
	}

	public static void main(String [] args)
	{
		Ejercicio8();
	}

}
