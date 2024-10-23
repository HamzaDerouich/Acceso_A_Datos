package ficheros.ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio12 {
	
	public static void AñadirDatos()
	{
		File fichero = new File("ficheros/usarios.txt");
		String nombre, apellido, telefono;
		Scanner scanner = new Scanner(System.in);
		int i = 0 ;
		while( i < 3 )
		{
			System.out.println("Digite el nombre: ");
			nombre = scanner.nextLine();
			System.out.println("Digite el apellido: ");
			apellido = scanner.nextLine();
			System.out.println("Digite el telefono: ");
			telefono = scanner.nextLine();
			
			try( BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero,true)))
			{
				escritor.write(nombre+";"+apellido+";"+telefono);
				escritor.write("");
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			i++;
			
		}
		
	}
	
	
	
	public static void main( String [] args )
	{
		AñadirDatos();
	}

}
