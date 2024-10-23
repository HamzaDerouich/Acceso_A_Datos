package ficheros.ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio14 {

	public static void LeerDatos()
	{
		Scanner sc = new Scanner(System.in);
		String ruta ;
		
		System.out.println("Digite la ruta: ");
		ruta = sc.nextLine();
		
		try {
			
			BufferedReader lector = new BufferedReader(new FileReader(new File(ruta)));
			
			String linea;
			while( ( linea = lector.readLine()) != null )
			{
				System.out.println(linea);
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
