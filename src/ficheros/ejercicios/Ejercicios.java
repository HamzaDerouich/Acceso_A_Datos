package ficheros.ejercicios;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicios {

	static Scanner sc = new Scanner(System.in);

	// 1. Mostrar la ruta absoluta de la carpeta actual.

	public static void Ejercicio1() {

		File rutaCarpeta = new File("");
		System.out.println(rutaCarpeta.getAbsolutePath());

	}

	// 2. Pedir por teclado una ruta de fichero o carpeta y mostrar si lo que se ha
	// introducido existe,
	// si es un fichero o una carpeta y el tamaño.

	public static void Ejercicio2() {

		String rutaFichero = "";
		System.out.println("Digite la ruta del fichero: ");
		rutaFichero = sc.nextLine();

		File ficheroDirectorio = new File(rutaFichero);

		boolean existe = ficheroDirectorio.exists();
		if (!existe) {
			System.out.println("No existe el fichero!!");
		} else {
			System.out.println("Tamaña fichero/directorio: " + rutaFichero.length());
		}

	}

	/*
	 * Mostrar el contenido de una carpeta cuya ruta se pide por teclado comprobando
	 * que existe y que es una carpeta. Del contenido se debe mostrar el nombre, si
	 * es fichero o carpeta, y las propiedades rwx
	 */

	public static void Ejercicio3() {

		String rutaFichero = "";
		System.out.println("Digite la ruta del fichero/directorio: ");
		rutaFichero = sc.nextLine();

		File ficheroDirectorio = new File(rutaFichero);

		boolean existe = ficheroDirectorio.exists();
		if (!existe) {
			System.out.println("No existe el fichero!!");
		} else {
			if (ficheroDirectorio.isFile()) {
				System.out.println("Es un Fichero" + "\nLectura: " + ficheroDirectorio.canRead() + "\nEscritura: "
						+ ficheroDirectorio.canWrite() + "\nEjecucion: " + ficheroDirectorio.canExecute());
			} else {
				System.out.println("Es un Directorio" + "\nLectura: " + ficheroDirectorio.canRead() + "\nEscritura: "
						+ ficheroDirectorio.canWrite() + "\nEjecucion: " + ficheroDirectorio.canExecute());
			}
		}

	}

	/*
	 * Crear una carpeta cuyo nombre se pide por teclado en la ruta por defecto.
	 * Comprobar antes de crear comprobar que la carpeta no existe.
	 */

	public static void Ejercicio4() {

		String rutaFichero = "";
		System.out.println("Digite la ruta del directorio: ");
		rutaFichero = sc.nextLine();

		File Directorio = new File(rutaFichero);

		boolean existe = Directorio.exists();
		if (!existe) {
			if (Directorio.mkdir()) {
				System.out.println("Directorio creado correctamente!");
			} else {
				System.out.println("Directorio no creado!");
			}
		} else {
			System.out.println("El directorio ya existe!!");
		}

	}

	/*
	 * Crear un fichero cuyo nombre se pide por teclado en la ruta por defecto.
	 * Comprobar antes de crear que el fichero no existe.
	 */

	public static void Ejercicio5() {

		String rutaFichero = "";
		System.out.println("Digite la ruta del fichero: ");
		rutaFichero = sc.nextLine();

		File fichero = new File(rutaFichero);

		boolean existe = fichero.exists();
		if (!existe) {
			try {
				if (fichero.createNewFile()) {
					System.out.println("Fichero creado correctamente!");
				} else {
					System.out.println("Fichero no creado!");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El fichero ya existe!!");
		}

	}

	/*
	 * Pedir por teclado una ruta de fichero y un nuevo nombre de fichero. El
	 * programa deberá renombrar el fichero original con el nuevo nombre en la
	 * carpeta original. Comprobar que el fichero original existe y que el nuevo no
	 * existe.
	 * 
	 */
	
	public static void Ejercicio6( ) {
		
		String viejoNombre = "";
		 String nuevaNombre = "";
		
		System.out.println("Digite la ruta del directorio del antiguo nombre: ");
		viejoNombre = sc.nextLine();
		
		System.out.println("Digite la ruta del directorio del nuevo nombre: ");
		nuevaNombre = sc.nextLine();


		File ficheroAntiguo = new File(viejoNombre);

		
		if (ficheroAntiguo.renameTo( new File(nuevaNombre))) {
			System.out.println("Renombrado correctamente!!");
		} else {
			System.out.println("No se ha podido renombrar!!");
		}
		
		
	}

	public static void main(String[] args) {

		// Ejercicio1();
		// Ejercicio2();
		// Ejercicio3();
		// Ejercicio4();
		//Ejercicio5();
		//Ejercicio6();

	}

}
