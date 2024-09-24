package ficheros.ejercicios;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Ejercicio7 {

	static LinkedHashSet<File> listadoFicheros = new LinkedHashSet<File>();
	static Scanner sc = new Scanner(System.in);

	/*
	 * Realiza un programa en java que pida por teclado nombres de ficheros que
	 * iremos guardando en una lista. Finalizada la lista, para cada uno de esos
	 * ficheros devolverá la siguiente información:
	 * 
	 */

	public static void AñadirFicherosLista() {

		
		String rutaFichero = "";
		
		while (!rutaFichero.equals("salir")) {
			
		
				System.out.println("Digite la ruta del fichero: ");
				rutaFichero = sc.nextLine();
				File file = new File(rutaFichero);
				if( !rutaFichero.equals("salir") ) {
					listadoFicheros.add(file);
				}else {
					
				}
			
			
		}

		for (File file : listadoFicheros) {
			System.out.println("=======================================");
			System.out.println(file.getName());
			System.out.println("=======================================");
			System.out.println("Existe el fichero: " + file.exists() + "\nEs un fichero: " + file.isFile()
					+ "\nEs un directorio: " + file.isDirectory() + "\nRuta absoluta: " + file.getAbsolutePath()
					+ "\nLectura: " + file.canRead() + "\nEscritura: " + file.canWrite() + "\nEjecucion: "
					+ file.canExecute() + "\nTamaño: " + file.length());

		}
		
		

	}

	public static void main(String[] args) {
		
		AñadirFicherosLista();
	}

}
