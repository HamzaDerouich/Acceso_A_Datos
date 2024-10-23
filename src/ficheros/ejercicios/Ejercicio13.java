package ficheros.ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio13 {

	public static void LeerDatos()
	{
		Scanner sc = new Scanner(System.in);
		String ruta ;
		
		System.out.println("Digite la ruta: ");
		ruta = sc.nextLine();
		
		try {
			
			BufferedReader lector = new BufferedReader(new FileReader(new File(ruta)));
			
			int c = 0;
			while( c != -1 )
			{
				c = lector.read();
				char caracter = (char) c ;
				System.out.println(caracter);
			}
			
			lector.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		LeerDatos();
	}

}
