package ficheros.ejercicios;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio10 {

	static Scanner sc = new Scanner(System.in);

	/*
	 * Crea un programa que solicita por teclado una ruta, verifica que la ruta es
	 * válida y nos mostrará los archivos que contiene dicho directorio ordenador
	 * por tamaño.
	 * 
	 */
	
	public static void Ejercicio10() {
		
		
		String rutaCarpeta = "";
		System.out.println("Introduce la ruta del directorio: ");
		rutaCarpeta = sc.nextLine();

		File directorio = new File(rutaCarpeta);
		File[] listado = directorio.listFiles();
		Arrays.sort(listado, new ComparatorTamaño());
		if (directorio.exists()) {
		    for (File file : listado) {
				System.out.println(file.getName() + " : " + file.length() + "bytes");
			}
			
		} else
		{
			System.out.println("Ruta no valida, intenteló con otra!!");
		}
		
	}

	public static void main(String[] args) {
		
		Ejercicio10();
	}

}
