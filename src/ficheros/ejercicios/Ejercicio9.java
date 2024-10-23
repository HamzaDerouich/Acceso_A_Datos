package ficheros.ejercicios;

import java.io.File;
import java.util.Scanner;

public class Ejercicio9 {

	/*
	 * Realiza un programa que borre un fichero que se pasa por parámetro. Antes de
	 * borrar se debe chequear que el fichero existe y pedir una confirmación de si
	 * realmente se quiere borrar
	 */

	public static void Ejercicio9() {

		Scanner sc = new Scanner(System.in);
		
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
}
