package ficheros.ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio17 
{
	public static void MostrarFichero()
	{
		String ruta = "ficheros/usuarios3.txt" ;
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
	
	public static void AgregarContenido()
	{
		Scanner sc = new Scanner(System.in);
		
		int contador_linea = 0 ;
		int linea_borrada = 0 ;
		String contenido = "";
		
		System.out.println("Digite la línea que deseas moficar: ");
		linea_borrada = Integer.parseInt(sc.nextLine());
		
		System.out.println("Digite el contenido de la línea: ");
		contenido = sc.nextLine();
		
		
		
		File fichero = new File("ficheros/usuarios3.txt");
		File temp = new File("ficheros/usuarios_temp.txt");
		
		try {
			
			BufferedReader lector = new BufferedReader(new FileReader(fichero));
			BufferedWriter escritor = new BufferedWriter(new FileWriter(temp));
			
			String linea;
			while( ( linea = lector.readLine() ) != null )
			{
			
				if( contador_linea == linea_borrada )
				{
					linea = contenido ;
					escritor.write(linea);
					escritor.newLine();
					
				}
				else
				{
					escritor.write(linea);
					escritor.newLine();
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
		AgregarContenido();
		MostrarFichero();

	}
}
