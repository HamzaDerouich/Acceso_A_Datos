package ficheros.ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio16 
{
	public static void MostrarFichero()
	{
		String ruta = "ficheros/usuarios2.txt" ;
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
	
	public static void BorrarLinea()
	{
		Scanner sc = new Scanner(System.in);
		
		int contador_linea = 0 ;
		int linea_borrada = 0 ;
		
		System.out.println("Digite la línea que deseas borrar: ");
		linea_borrada = Integer.parseInt(sc.nextLine());
		
		File fichero = new File("ficheros/usuarios2.txt");
		File temp = new File("ficheros/usuarios_temp.txt");
		
		try {
			
			BufferedReader lector = new BufferedReader(new FileReader(fichero));
			BufferedWriter escritor = new BufferedWriter(new FileWriter(temp));
			
			String linea;
			while( ( linea = lector.readLine() ) != null )
			{
			
				if( contador_linea != linea_borrada )
				{
					escritor.write(linea);
					escritor.write("");
				}
				
				contador_linea++;
				
			}
			
			escritor.close();
			lector.close();
			
			if(!fichero.delete())
			{
				System.out.println("No se ha podido borrar el fichero!");
			}
			
			if(!temp.renameTo(fichero))
			{
				System.out.println("No se ha podido renombrar el fichero");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main( String [] args )
	{
		MostrarFichero();
		BorrarLinea();
	}
}
