package ficheros.ejercicios;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio8_9_10 {

	static Scanner sc = new Scanner(System.in);

	/*
	 * Realiza un programa que pida por teclado una ruta de carpeta y si existe
	 * muestre su contenido y el contenido de todos sus hijos tantos directos como
	 * indirectos. Tal y como muestra la imagen.
	 */

	public static void Ejercicio8() {

		String rutaCarpeta = "";
		System.out.println("Introduce la ruta de la carpeta: ");
		rutaCarpeta = sc.nextLine();

		File directorio = new File(rutaCarpeta);
		File[] file = directorio.listFiles();

		System.out.println("[D] " + directorio.getName());
		for (File i : file) {
			if (i.isDirectory()) {
				System.out.println("\tab[D] " + i.getName());
			} else {
				System.out.println("\tab[F] " + i.getName());
			}
		}

	}

	/*
	 * Realiza un programa que borre un fichero que se pasa por parámetro. Antes de
	 * borrar se debe chequear que el fichero existe y pedir una confirmación de si
	 * realmente se quiere borrar
	 */

	public static void Ejercicio9() {

		String rutaCarpeta = "";
		char opcion;
		System.out.println("Introduce la ruta del fichero a borrar: ");
		rutaCarpeta = sc.nextLine();

		File directorio = new File(rutaCarpeta);

		if (directorio.exists()) {
			try {
				System.out.println("¿Seguro que deseas borrar el fichero" + directorio.getName() + "(s/n)");
				opcion = sc.next().charAt(0);
				if (opcion == 's') {
					System.out.println("Fichero borrado correctamente.");
					directorio.delete();
				} else {
					System.out.println("Fichero no borrado!!");
				}

			} catch (NumberFormatException e) {
				System.out.println("Error datos no validos");
			}

		}

	}
	

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
		// Ejercicio8();
		//Ejercicio9();
		Ejercicio10();
	}

}
