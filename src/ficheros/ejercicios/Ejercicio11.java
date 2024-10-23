package ficheros.ejercicios;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio11 {


	public static void AñadirDatos()
	{
		Scanner scanner = new Scanner(System.in);
		
		String ruta = "";
		String datos = "";

		System.out.println("Digite la ruta del fichero: ");
		ruta = scanner.nextLine();
		
		System.out.println("Digite el contenido: ");
		datos = scanner.nextLine();
		
		File fichero = new File(ruta);
	
		try {
			
			BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero));
			
			escritor.write(datos);
			
			escritor.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) 
	{
		AñadirDatos();
	}

}
