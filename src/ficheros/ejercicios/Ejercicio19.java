package ficheros.ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio19 {
	
	public static void Cotizaciones2()
	{
		File fichero = new File("ficheros/ej19_cotizacion.txt");
		File fichero_temp = new File("ficheros/cotizaciones2.txt");
		
		int contador_linea_uno = 1 ;
		int contador_linea_dos = 2 ;
		int contador_lineas = 0 ;
		
		try {
			
			BufferedReader lector = new BufferedReader(new FileReader(fichero));
			BufferedWriter escritor = new BufferedWriter(new FileWriter(fichero_temp));
			
			String linea ;
			String info_nombre = "";
			String info_precio = "";
			while( ( linea = lector.readLine()) != null )
			{
				
				if( contador_linea_uno == contador_lineas )
				{
					info_nombre = linea ;
					contador_linea_uno += 5;
				}
				
				if( contador_linea_dos == contador_lineas )
				{
					info_precio = linea;
					escritor.write( info_nombre+";"+info_precio );
					escritor.newLine();
					contador_linea_dos += 5 ;
				}
				
				contador_lineas++;
			}
			
			escritor.close();
			lector.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main( String [] args )
	{
		Cotizaciones2();
	}

}
