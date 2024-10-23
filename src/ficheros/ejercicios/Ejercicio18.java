package ficheros.ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio18
{
	public static void PasarAMayusculas()
	{
		Scanner sc = new Scanner( System.in );
		String ruta_fichero = "";
		
		System.out.println("Digite la ruta del fichero.....");
		ruta_fichero = sc.nextLine();
		
		
		File fichero = new File(ruta_fichero);
		File fichero_temp = new File("FicheroMayusulas.txt");
		
		try {
			
			BufferedReader lector = new BufferedReader(new FileReader(fichero));
			BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero_temp));
			
			int c = 0 ;
			while( c != -1 )
			{
				c = lector.read();
				char caracter = (char) c ;
				
				if( Character.isUpperCase(caracter))
				{
					escritor.write(Character.toLowerCase(caracter));
				}
				else
				{
					escritor.write(Character.toUpperCase(caracter));
				}
				
			}
			
			escritor.close();
			lector.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args)
	{
		PasarAMayusculas();
	}
}
